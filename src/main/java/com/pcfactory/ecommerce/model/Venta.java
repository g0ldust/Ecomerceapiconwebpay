package com.pcfactory.ecommerce.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;

    @Column(nullable = false, unique = false)
    private Date fechaVenta;

    @Column(nullable = false, unique = false)
    private Long idCliente;

    @Column(nullable = false, unique = false)
    private Integer subtotalVenta;

    @Column(nullable = false, unique = false)
    private Integer ivaVenta;

    @Column(nullable = false, unique = false)
    private Integer totalVenta;

}
