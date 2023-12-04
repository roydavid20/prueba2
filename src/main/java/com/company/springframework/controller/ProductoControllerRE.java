package com.company.springframework.controller;

import com.company.springframework.model.Producto;
import com.company.springframework.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoRE")
public class ProductoControllerRE {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarTodosLosProductos() {
        return ResponseEntity.ok(productoService.listarTodosLosProductos());
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        producto.setId(id);
        Producto ProductoActualizado = productoService.actualizarProducto(producto);
        return ProductoActualizado != null ? ResponseEntity.ok(ProductoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}



