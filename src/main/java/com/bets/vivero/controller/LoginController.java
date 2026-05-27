/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.repository.ClienteRepository;
import com.bets.vivero.repository.PedidoRepository;
import com.bets.vivero.repository.ProductoRepository;
import com.bets.vivero.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Wyrnm
 */
@Controller
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Obtenemos los conteos totales directamente desde la base de datos MySQL
        model.addAttribute("totalClientes", clienteRepository.count());
        model.addAttribute("totalProductos", productoRepository.count());
        model.addAttribute("totalProveedores", proveedorRepository.count());
        model.addAttribute("totalPedidos", pedidoRepository.count());

        return "dashboard";
    }

    @GetMapping("/")
    public String raiz() {
        return "redirect:/login";
    }
}
