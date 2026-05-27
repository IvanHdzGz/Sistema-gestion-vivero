/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.repository;

import com.bets.vivero.model.DetalleCompra;
import com.bets.vivero.model.DetalleCompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wyrnm
 */
@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, DetalleCompraPK> {
}