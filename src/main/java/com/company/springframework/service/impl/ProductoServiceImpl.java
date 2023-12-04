package com.company.springframework.service.impl;


import com.company.springframework.model.Producto;
import com.company.springframework.repository.ProductoRepository;
import com.company.springframework.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        validarProducto(producto);
        return productoRepository.save(producto);

    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        validarProducto(producto);
        if (!productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if(!productoRepository.existsById(id)){
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        productoRepository.deleteById(id);
        throw new IllegalArgumentException("producto eliminado");

    }

    @Override
    public List<Producto> listarTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    private void validarProducto(Producto producto) {
        if (producto.getDescripcion() == null || producto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del producto no puede estar vacía.");
        }
        if (producto.getPrecio() == null || producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        if (producto.getEstado() < 0) {
            throw new IllegalArgumentException("El estado no puede ser negativo.");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getIdCategoria() == null) {
            throw new IllegalArgumentException("La categoría asignada no es válida.");
        }
    }

}

