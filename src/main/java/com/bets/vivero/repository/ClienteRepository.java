/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.repository;

import com.bets.vivero.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wyrnm
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Manda a llamar al procedimiento almacenado de la base de datos
    @Procedure(name = "sp_total_gastado_cliente")
    Double obtenerTotalGastadoCliente(@Param("p_cli_id") Integer cliId);
}
