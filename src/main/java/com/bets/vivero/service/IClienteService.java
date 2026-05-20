/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.service;

import com.bets.vivero.model.Cliente;
import java.util.List;

/**
 *
 * @author Wyrnm
 */
public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente buscarClientePorId(Integer id);

    public Cliente guardarCliente(Cliente cliente);

    public void eliminarCliente(Integer id);
}
