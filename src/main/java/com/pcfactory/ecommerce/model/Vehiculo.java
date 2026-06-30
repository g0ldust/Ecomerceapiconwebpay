package com.pcfactory.ecommerce.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100, unique = false)
    private Integer id_marca;

    @Column(nullable = false, length = 100, unique = false)
    private Integer id_modelo;

    @Column(nullable = false, length = 4, unique = false)
    private Integer anio;

    @Column(nullable = false, length = 100, unique = false)
    private String color;

    @Column(nullable = false, length = 6, unique = true)
    private String patente;
}
