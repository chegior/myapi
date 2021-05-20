package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "Pedidos")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Long id;
    @Column(name = "numeroTracking")
    private String trackingNumber;
    @Column(name = "totalCantidad")
    private int totalQuantity;
    @Column(name = "totalPreico")
    private BigDecimal totalPrice;
    @CreationTimestamp
    @Column(name = "fechaCreacion")
    private Date dateCreated;
    @UpdateTimestamp
    @Column(name = "fechaActualizacion")
    private Date lastUpdated;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "direccionFacturacion", referencedColumnName = "idDireccion")
    private Address billingaddress;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "direccionEnvio", referencedColumnName = "idDireccion")
    private Address shippingAddress;


    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetails> orderDetails;

    public void addOrderDetail(OrderDetails od){
        if (orderDetails == null){
            orderDetails = new HashSet<>();
        }
        orderDetails.add(od);
        od.setOrder(this);

    }
}
