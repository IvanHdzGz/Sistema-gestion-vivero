/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.service;

import com.bets.vivero.model.Producto;
import java.util.List;

/**
 *
 * @author Wyrnm
 */
public interface IProductoService {

    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer id);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Integer id);
}
