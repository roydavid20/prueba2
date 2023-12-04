package com.company.springframework;

import com.company.springframework.model.Categoria;
import com.company.springframework.model.Producto;

import static org.assertj.core.api.Assertions.assertThat;

import com.company.springframework.repository.CategoriaRepository;
import com.company.springframework.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringframeworkInitialApplicationTests {



    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void insertarProducto() {


        Categoria categoria = new Categoria();
        categoria.setDescripcion("Electrónicos");
        Categoria categoriaRegistrada = categoriaRepository.save(categoria);


        Producto producto = new Producto();
        producto.setDescripcion("Laptop");
        producto.setPrecio(1200.00);
        producto.setStock(10);
        producto.setEstado(1);
        producto.setCategoria(categoriaRegistrada);


        Producto productoRegistrado = productoRepository.save(producto);


        assertThat(productoRegistrado).isNotNull();
        assertThat(productoRegistrado.getId()).isPositive();
        assertThat(productoRegistrado.getDescripcion()).isNotEmpty();
        assertThat(productoRegistrado.getPrecio()).isNotNull();
        assertThat(productoRegistrado.getStock()).isPositive();
        assertThat(productoRegistrado.getEstado()).isPositive();
        assertThat(productoRegistrado.getCategoria()).isNotNull();
        assertThat(productoRegistrado.getCategoria().getIdCategoria()).isPositive();
        assertThat(productoRegistrado.getCategoria().getDescripcion()).isNotEmpty();

    }
}