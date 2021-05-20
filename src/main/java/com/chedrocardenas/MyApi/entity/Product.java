package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Productos")//Indicar la tabla
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long id;
    @Column(name = "nombreProducto")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "precioUnitario")
    private BigDecimal unitPrice;
    private String imageUrl;//Like the name is equal to the DB no need for the ANNOTATION

    @ManyToOne //Base on our DATA MODEL !!!
            @JoinColumn(name = "idCategoria")
    Category category;
}
