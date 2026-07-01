package com.pcfactory.ecommerce.service;

import com.pcfactory.ecommerce.dto.WebpayCreateRequest;
import com.pcfactory.ecommerce.dto.WebpayCreateResponse;
import com.pcfactory.ecommerce.model.Transaccion;
import com.pcfactory.ecommerce.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WebpayService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private WebClient webpayWebClient;

    public Map<String, Object> iniciarPago(BigDecimal monto, String urlRetorno){
        Map<String, Object> resultado = new HashMap<>();
        try {
            String buyOrder = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
            String sessionId = "SESS-" + UUID.randomUUID().toString().substring(0, 8);

            WebpayCreateRequest requestBody = new WebpayCreateRequest(
                    buyOrder, sessionId, monto.doubleValue(), urlRetorno
            );

            WebpayCreateResponse response = webpayWebClient.post()
                    .uri("/rswebpaytransaction/api/webpay/v1.2/transactions")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(WebpayCreateResponse.class)
                    .block();

            Transaccion transaccion = new Transaccion();
            transaccion.setBuyOrder(buyOrder);
            transaccion.setSessionId(sessionId);
            transaccion.setAmount(monto);
            transaccion.setEstado("CREADO");
            transaccion.setFechaCreacion(LocalDateTime.now());
            transaccion.setTokenWebpay(response.getToken());

            transaccionRepository.save(transaccion);

            resultado.put("token", response.getToken());
            resultado.put("url", response.getUrl());
            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getClass().getName());
            error.put("mensaje", e.getMessage());
            return error;
        }
    }

    public Transaccion finalizarPago(String token, String status) {
        try {

            Map<String, Object> webpayStatus = webpayWebClient.put()
                    .uri("/rswebpaytransaction/api/webpay/v1.2/transactions/" + token)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            //String realStatus = (String) webpayStatus.get("status");
            String realStatus = status;
            return transaccionRepository.findByTokenWebpay(token)
                    .map(transaccion -> {
                        if ("AUTHORIZED".equalsIgnoreCase(realStatus) || "APPROVED".equalsIgnoreCase(realStatus)) {
                            transaccion.setEstado("PAGADO");
                        } else {
                            transaccion.setEstado("NO PAGADO");
                        }
                        return transaccionRepository.save(transaccion);
                    }).orElse(null);

        } catch (Exception e) {
            e.printStackTrace();
            return transaccionRepository.findByTokenWebpay(token)
                    .map(t -> {
                        t.setEstado("NO PAGADO");
                        return transaccionRepository.save(t);
                    }).orElse(null);
        }
    }
}