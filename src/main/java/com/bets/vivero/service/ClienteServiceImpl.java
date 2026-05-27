/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.service;

import com.bets.vivero.model.Cliente;
import com.bets.vivero.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wyrnm
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Devuelve la lista completa de clientes registrados en MySQL
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Busca un cliente por su ID. Si no lo encuentra, devuelve null
    @Override
    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Guarda un cliente nuevo o actualiza uno existente
    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Elimina un cliente por ID
    @Override
    public void eliminarCliente(Integer id) {
        // Usa el método nativo de JPA para borrar de la base de datos por su ID
        clienteRepository.deleteById(id);
    }

    // Devuelve el total gastado del cliente
    @Override
    @Transactional // En spring los procedimientos requieren que el método sea transaccional
    public Double getTotalGastado(Integer idCliente) {
        return clienteRepository.obtenerTotalGastadoCliente(idCliente);
    }
}
