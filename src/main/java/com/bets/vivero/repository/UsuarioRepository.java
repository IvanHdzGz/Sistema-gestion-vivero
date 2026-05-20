/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.repository;

import com.bets.vivero.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wyrnm
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca en la BD usando el atributo "email" de tu clase Java
    Usuario findByEmail(String email);
}
