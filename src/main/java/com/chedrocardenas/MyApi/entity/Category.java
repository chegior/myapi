package com.chedrocardenas.MyApi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//ANOTACION
@Entity
@Table(name = "Categorias")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long id;

    @Column(name = "nombreCategoria")
    private String name;

    //1 to many = ARRAY, accomplished by the Annotation
    @OneToMany(mappedBy = "category")
    Set<Product> products;
}

//Como decirle que es una clase ENTIDAD -> son aquellas que solo tienen PROPIEDADED -> Campos de la TABLA
//Relationship Mapping atraves de las ANOTACIONES
