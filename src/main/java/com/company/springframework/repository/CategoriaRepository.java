package com.company.springframework.repository;

import com.company.springframework.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
}
