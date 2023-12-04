package com.company.springframework.controller;

import com.company.springframework.model.Categoria;
import com.company.springframework.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaRE")
public class CategoriaRE {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasLasCategorias() {
        return ResponseEntity.ok(categoriaService.listarTodosLasCategorias());
    }

    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaService.guardarCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        categoria.setIdCategoria(id);
        Categoria categoriaActualizada = categoriaService.actualizarCategoria(categoria);
        return categoriaActualizada != null ? ResponseEntity.ok(categoriaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
