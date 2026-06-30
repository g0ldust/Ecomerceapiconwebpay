package com.pcfactory.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false, unique = true)
    private Integer rut;

    @Column(nullable = false, unique = false)
    private Integer digitoVerificador;

    @Column(nullable = false, length = 100, unique = false)
    private String nombresCliente;

    @Column(nullable = false, length = 100, unique = false)
    private String apellidosCliente;

    @Column(nullable = false, length = 100, unique = true)
    private String emailCliente;

    @Column(nullable = false, unique = true)
    private Integer telefonoCliente;
}
