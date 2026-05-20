package com.bets.vivero;

import com.bets.vivero.model.Usuario;
import com.bets.vivero.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ViveroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViveroApplication.class, args);
    }
/*
    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository) {
        return args -> {
            // Verifica existencia del usuario
            Usuario existente = usuarioRepository.findByEmail("admin@vivero.com");

            if (existente != null) {
                // Se elimina para limpiar errores de caracteres
                usuarioRepository.delete(existente);
                System.out.println("Limpiando usuario previo para regeneración limpia...");
            }
            
            // Se crea el usuarioutilizando el encriptador nativo de Java
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            Usuario admin = new Usuario();
            admin.setEmail("admin@vivero.com");
            admin.setNombre("Iván");
            admin.setApellido("Hernández");
            // Java se encarga de generar el Hash perfecto aquí:
            admin.setPswd(encoder.encode("admin123"));

            usuarioRepository.save(admin);
            System.out.println("¡Usuario administrador generado con éxito desde Java!");
        };
    }
*/
}
