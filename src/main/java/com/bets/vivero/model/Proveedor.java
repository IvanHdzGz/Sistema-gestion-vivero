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
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prov_id;

    @Column(nullable = false, length = 150)
    private String prov_nombre;

    @Column(length = 150)
    private String prov_email;

    @Column(length = 20)
    private String prov_telefono;

    // Constructor vacío
    public Proveedor() {
    }

    // Constructor con 4 parámetros
    public Proveedor(Integer prov_id, String prov_nombre, String prov_email, String prov_telefono) {
        this.prov_id = prov_id;
        this.prov_nombre = prov_nombre;
        this.prov_email = prov_email;
        this.prov_telefono = prov_telefono;
    }

    // Getters
    public Integer getProv_id() {
        return prov_id;
    }

    public String getProv_nombre() {
        return prov_nombre;
    }

    public String getProv_email() {
        return prov_email;
    }

    public String getProv_telefono() {
        return prov_telefono;
    }

    // Setters
    public void setProv_id(Integer prov_id) {
        this.prov_id = prov_id;
    }

    public void setProv_nombre(String prov_nombre) {
        this.prov_nombre = prov_nombre;
    }

    public void setProv_email(String prov_email) {
        this.prov_email = prov_email;
    }

    public void setProv_telefono(String prov_telefono) {
        this.prov_telefono = prov_telefono;
    }
}
