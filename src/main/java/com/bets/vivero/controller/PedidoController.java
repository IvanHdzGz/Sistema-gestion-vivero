/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.model.Pedido;
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

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute("nuevoPedido") Pedido pedido) {
        if (pedido.getDetalles() != null) {
            pedido.getDetalles().forEach(detalle -> {
                detalle.setPedido(pedido);

                if (detalle.getProducto() != null) {
                    detalle.setProducto(detalle.getProducto());
                }
            });
        }

        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable("id") Integer id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}
