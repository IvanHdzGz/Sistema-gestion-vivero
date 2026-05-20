/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.model.Producto;
import com.bets.vivero.service.ICategoriaService;
import com.bets.vivero.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wyrnm
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICategoriaService categoriaService;

    // 1. LISTAR PRODUCTOS Y LLENAR FORMULARIOS
    @GetMapping
    public String listarProductos(Model model) {
        // Enviamos la lista de productos reales a la tabla
        model.addAttribute("productos", productoService.listarProductos());

        // Enviamos las categorías para llenar el <select> del modal
        model.addAttribute("categorias", categoriaService.listarCategorias());

        // Creamos un objeto Producto vacío para el formulario (th:object="${productoObj}")
        model.addAttribute("productoObj", new Producto());

        return "productos"; // Busca productos.html en templates
    }

    // 2. GUARDAR / ACTUALIZAR PRODUCTO
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("productoObj") Producto producto) {
        // Spring Data JPA detecta automáticamente si el prod_id ya existe:
        // Si no existe, hace un INSERT. Si ya existe, hace un UPDATE.
        productoService.guardarProducto(producto);
        return "redirect:/productos"; // Recarga la pantalla para ver los cambios
    }

    // 3. ELIMINAR PRODUCTO
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos"; // Recarga la pantalla
    }
}
