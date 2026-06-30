package com.pcfactory.ecommerce.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "buy_order", nullable = false, unique = true)
    private String buyOrder;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "token_webpay")
    private String tokenWebpay;

    @Column(name = "estado", nullable = false)
    private String estado; // CREADO, NO PAGADO, PAGADO

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Transaccion() {
    }

    public Transaccion(String buyOrder, String sessionId, BigDecimal amount, String estado, LocalDateTime fechaCreacion) {
        this.buyOrder = buyOrder;
        this.sessionId = sessionId;
        this.amount = amount;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBuyOrder() { return buyOrder; }
    public void setBuyOrder(String buyOrder) { this.buyOrder = buyOrder; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getTokenWebpay() { return tokenWebpay; }
    public void setTokenWebpay(String tokenWebpay) { this.tokenWebpay = tokenWebpay; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}