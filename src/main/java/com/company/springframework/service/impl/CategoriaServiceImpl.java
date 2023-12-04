package com.company.springframework.service.impl;

import com.company.springframework.model.Categoria;
import com.company.springframework.repository.CategoriaRepository;
import com.company.springframework.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;
    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        validarCategoria(categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        validarCategoria(categoria);
        if (!categoriaRepository.existsById(categoria.getIdCategoria())) {
            throw new IllegalArgumentException("La categoría con el ID especificado no existe.");
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long idCategoria) {
        if (!categoriaRepository.existsById(idCategoria)) {
            throw new IllegalArgumentException("La categoría con el ID especificado no existe.");
        }
        categoriaRepository.deleteById(idCategoria);
        throw new IllegalArgumentException("Categoria Eliminada");

    }

    @Override
    public List<Categoria> listarTodosLasCategorias() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    private void validarCategoria(Categoria categoria) {
        if (categoria.getDescripcion() == null || categoria.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la categoría no puede estar vacía.");
        }
    }
}
