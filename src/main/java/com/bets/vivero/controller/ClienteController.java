/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.model.Cliente;
import com.bets.vivero.service.IClienteService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("clienteObj", new Cliente()); // Objeto vacío para el formulario
        return "clientes";
    }

    // Guardar o Actualizar
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("clienteObj") Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    // Eliminar por ID
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Integer id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
