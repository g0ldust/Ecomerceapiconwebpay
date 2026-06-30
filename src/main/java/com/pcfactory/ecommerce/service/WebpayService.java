package com.pcfactory.ecommerce.service;

import com.pcfactory.ecommerce.model.Transaccion;
import com.pcfactory.ecommerce.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WebpayService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    public WebpayService() {
    }

    public Map<String, Object> iniciarPago(BigDecimal monto, String urlRetorno){
        Map<String, Object> resultado = new HashMap<>();
        try {
            String buyOrder = "ORD-" + UUID.randomUUID().toString().substring(0, 8);
            String sessionId = "SESS-" + UUID.randomUUID().toString().substring(0, 8);
            String tokenSimulado = "01ab" + UUID.randomUUID().toString().replace("-", "");
            String urlSimulada = "https://webpay3gint.transbank.cl/rswebpaytransaction/api/webpay/v1.2/transactions";

            Transaccion transaccion = new Transaccion();
            transaccion.setBuyOrder(buyOrder);
            transaccion.setSessionId(sessionId);
            transaccion.setAmount(monto);
            transaccion.setEstado("CREADO");
            transaccion.setFechaCreacion(LocalDateTime.now());
            transaccion.setTokenWebpay(tokenSimulado);

            transaccionRepository.save(transaccion);

            resultado.put("token", tokenSimulado);
            resultado.put("url", urlSimulada);
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
        return transaccionRepository.findByTokenWebpay(token)
                .map(transaccion -> {
                    if ("AUTHORIZED".equalsIgnoreCase(status) || "APPROVED".equalsIgnoreCase(status)) {
                        transaccion.setEstado("PAGADO");
                    } else {
                        transaccion.setEstado("NO PAGADO");
                    }
                    return transaccionRepository.save(transaccion);
                }).orElse(null);
    }

}
