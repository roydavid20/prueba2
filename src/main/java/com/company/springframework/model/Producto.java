package com.company.springframework.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Double precio;
    private int stock;
    private int estado;

    @ManyToOne
    private Categoria categoria;

}
