package com.company.springframework.service;


import com.company.springframework.model.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Long id);


    List<Producto> listarTodosLosProductos();
}
