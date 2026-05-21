/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Wyrnm
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cat_id;

    @Column(nullable = false, length = 100)
    private String cat_nombre;

    @Column(columnDefinition = "TEXT")
    private String cat_descripcion;

    // Relación inversa: Una categoría tiene muchos productos
    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Producto> productos;

    // Constructor vacío
    public Categoria() {
    }

    // Constructor con 4 parámetros
    public Categoria(Integer cat_id, String cat_nombre, String cat_descripcion, List<Producto> productos) {
        this.cat_id = cat_id;
        this.cat_nombre = cat_nombre;
        this.cat_descripcion = cat_descripcion;
        this.productos = productos;
    }

    // Getters
    public Integer getCat_id() {
        return cat_id;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public String getCat_descripcion() {
        return cat_descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Setters
    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public void setCat_descripcion(String cat_descripcion) {
        this.cat_descripcion = cat_descripcion;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
