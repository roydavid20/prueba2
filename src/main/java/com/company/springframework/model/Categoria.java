package com.company.springframework.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categoria")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String descripcion;
}
