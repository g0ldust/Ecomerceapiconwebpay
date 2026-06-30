package com.pcfactory.ecommerce.controller;

import com.pcfactory.ecommerce.model.Vehiculo;
import com.pcfactory.ecommerce.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/api/v1/vehiculo")
    public ResponseEntity<?> getVehiculos() {
        List<Vehiculo> vehiculos =vehiculoService.findAll();
        return ResponseEntity.status(200).body(vehiculos);
    }

}
