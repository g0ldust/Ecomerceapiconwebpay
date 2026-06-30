package com.pcfactory.ecommerce.controller;
import com.pcfactory.ecommerce.model.Cliente;
import com.pcfactory.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController


public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/api/v1/clientes")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(clienteService.findAll());
    }


}
