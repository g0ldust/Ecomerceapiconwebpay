package com.pcfactory.ecommerce.repository;

import com.pcfactory.ecommerce.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
    Optional<Transaccion> findByBuyOrder(String buyOrder);
    Optional<Transaccion> findByTokenWebpay(String tokenWebpay);
}
