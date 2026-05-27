/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.model.DetallePedido;
import com.bets.vivero.model.Pedido;
import com.bets.vivero.model.Producto;
import com.bets.vivero.repository.ClienteRepository;
import com.bets.vivero.repository.PedidoRepository;
import com.bets.vivero.repository.ProductoRepository;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    
    @GetMapping
    public String listarPedidos(Model model) {
        // Llenamos todas las entidades necesarias para los combos y alertas del HTML
        model.addAttribute("pedidos", pedidoRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        // Pasamos un objeto vacío mapeable al modal de creación
        model.addAttribute("nuevoPedido", new Pedido());
        return "pedidos";
    }

    // Guardar el pedido
    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        if (pedido.getDetalles() != null) {
            for (DetallePedido detalle : pedido.getDetalles()) {
                detalle.setPedido(pedido);

                // Forzamos a Hibernate a traer el producto real del catálogo
                if (detalle.getProducto() != null && detalle.getProducto().getProd_id() != null) {
                    Producto prodExistente = productoRepository.findById(detalle.getProducto().getProd_id()).orElse(null);
                    detalle.setProducto(prodExistente);
                }
            }
        }

        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    // Eliminar el pedido
    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable("id") Integer id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}
