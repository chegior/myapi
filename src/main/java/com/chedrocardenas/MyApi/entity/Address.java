package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Direcciones")
@Getter
@Setter
public class Address {
    @Column(name = "idDireccion")
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "departamento")
    private String dep;
    @Column(name = "provincia")
    private String prov;
    @Column(name = "distrito")
    private String dist;
    @Column(name = "direccion")
    private String street;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

}
