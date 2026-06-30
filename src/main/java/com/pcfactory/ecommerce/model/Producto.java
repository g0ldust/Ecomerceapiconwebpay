package com.pcfactory.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false, unique = true)
    private Integer sku;

    @Column(nullable = false, unique = false)
    private Integer stock;

    @Column(nullable = false, unique = false)
    private Integer idMarca;

    @Column(nullable = false, unique = false)
    private Integer idModelo;

    @Column(nullable = false, unique = false)
    private Integer precioProducto;


}
