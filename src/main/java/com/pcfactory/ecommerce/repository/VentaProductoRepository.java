package com.pcfactory.ecommerce.repository;

import com.pcfactory.ecommerce.model.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VentaProductoRepository extends JpaRepository<VentaProducto, Long> {
}
