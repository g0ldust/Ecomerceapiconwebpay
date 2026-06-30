package com.pcfactory.ecommerce.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ventas_productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVentaProducto;

    @Column(nullable = false, unique = false)
    private Long idVenta;

    @Column(nullable = false, unique = false)
    private Long idProducto;

    @Column(nullable = false, unique = false)
    private Integer cantidadVentaProducto;

}
