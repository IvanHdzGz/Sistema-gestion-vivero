/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.controller;

import com.bets.vivero.model.Usuario;
import com.bets.vivero.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Wyrnm
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Muestra la vista para crear un usuario nuevo
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // Buscará registro.html en templates
    }

    // Procesa el formulario e inserta el registro con contraseña hash
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        // Encriptamos la contraseña en texto plano con BCrypt usando tu Bean configurado
        String pswdEncriptada = passwordEncoder.encode(usuario.getPswd());

        // Reasignamos el hash seguro al objeto usuario
        usuario.setPswd(pswdEncriptada);

        // Almacenamos en la Base de Datos
        usuarioRepository.save(usuario);

        // Redirigimos al login con un parámetro de éxito opcional
        return "redirect:/login?registrado";
    }
}
