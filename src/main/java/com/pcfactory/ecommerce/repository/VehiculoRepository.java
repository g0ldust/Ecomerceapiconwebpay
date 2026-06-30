package com.pcfactory.ecommerce.repository;
import com.pcfactory.ecommerce.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
