package com.pcfactory.ecommerce.controller;

import com.pcfactory.ecommerce.service.WebpayService;
import com.pcfactory.ecommerce.model.Transaccion;
import com.pcfactory.ecommerce.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/webpay")
public class Webpaycontroller {
    @Autowired
    private  WebpayService webpayService;

    @GetMapping("/crear")
    public ResponseEntity<?> crearTransaccion(@RequestParam BigDecimal monto,
                                              @RequestParam String urlRetorno) {

        Map<String, Object> respuesta = webpayService.iniciarPago(monto, urlRetorno);

        if (respuesta.containsKey("error")) {
            return ResponseEntity.badRequest().body(respuesta);
        }

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/confirmar")
    public ResponseEntity<?> confirmarTransaccion(@RequestParam String token, @RequestParam String status) {
        Transaccion transaccionActualizada = webpayService.finalizarPago(token, status);
        if (transaccionActualizada != null) {
            return ResponseEntity.ok(transaccionActualizada);
        }
        return ResponseEntity.notFound().build();
    }

}
