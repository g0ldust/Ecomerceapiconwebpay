package com.pcfactory.ecommerce.service;

import com.pcfactory.ecommerce.model.Vehiculo;
import com.pcfactory.ecommerce.repository.VehiculoRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> findAll(){
        return vehiculoRepository.findAll();

    }
    public Vehiculo BuscarporId(long id){
        return vehiculoRepository.findById((int) id).get();
    }
}
