package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detallePedido")
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetallePedido")
    private Long id;
    @Column(name = "precio")
    private BigDecimal unitPrice;
    @Column(name = "cantidad")
    private int quantity;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "idProdcuto")
    private int productId;

    @ManyToOne
    @JoinColumn(name="idPedido")
    private Order order;

}
