/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.service;

import com.bets.vivero.model.Categoria;
import java.util.List;

/**
 *
 * @author Wyrnm
 */
public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public Categoria buscarCategoriaPorId(Integer id);

    public Categoria guardarCategoria(Categoria categoria);

    public void eliminarCategoria(Integer id);
}
