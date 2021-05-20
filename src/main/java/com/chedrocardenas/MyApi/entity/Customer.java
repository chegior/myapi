package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Clientes")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;
    @Column(name = "nombreCliente")
    private String name;
    @Column(name = "apellidoCliente")
    private String lastName;
    @Column(name = "correo")
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    public void addOrder(Order order){
        if(orders == null){
            orders = new HashSet<>();
        }
        orders.add(order);
        order.setCustomer(this);
    }
}
