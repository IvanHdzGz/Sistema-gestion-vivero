/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Wyrnm
 */
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cli_id;

    @Column(nullable = false, length = 150)
    private String cli_nombre;

    @Column(length = 150)
    private String cli_apellido;

    @Column(length = 20)
    private String cli_telefono;

    @Column(length = 150)
    private String cli_email;

    @Column(length = 50)
    private String cli_estado;

    @Column(length = 100)
    private String cli_ciudad;

    @Column(length = 10)
    private String cli_cp;

    @Column(columnDefinition = "TEXT")
    private String cli_direccion;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con 9 parámetros
    public Cliente(Integer cli_id, String cli_nombre, String cli_apellido, String cli_telefono, String cli_email, String cli_estado, String cli_ciudad, String cli_cp, String cli_direccion) {
        this.cli_id = cli_id;
        this.cli_nombre = cli_nombre;
        this.cli_apellido = cli_apellido;
        this.cli_telefono = cli_telefono;
        this.cli_email = cli_email;
        this.cli_estado = cli_estado;
        this.cli_ciudad = cli_ciudad;
        this.cli_cp = cli_cp;
        this.cli_direccion = cli_direccion;
    }

    // Getters
    public Integer getCli_id() {
        return cli_id;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public String getCli_email() {
        return cli_email;
    }

    public String getCli_estado() {
        return cli_estado;
    }

    public String getCli_ciudad() {
        return cli_ciudad;
    }

    public String getCli_cp() {
        return cli_cp;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    // Setters
    public void setCli_id(Integer cli_id) {
        this.cli_id = cli_id;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public void setCli_estado(String cli_estado) {
        this.cli_estado = cli_estado;
    }

    public void setCli_ciudad(String cli_ciudad) {
        this.cli_ciudad = cli_ciudad;
    }

    public void setCli_cp(String cli_cp) {
        this.cli_cp = cli_cp;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

}
