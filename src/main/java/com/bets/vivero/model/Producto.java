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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Wyrnm
 */
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prod_id;

    @Column(nullable = false, length = 150)
    private String prod_nombre;

    @Column(length = 255)
    private String prod_imgurl;

    @Column(nullable = false)
    private Double prod_precio;

    @Column(nullable = false)
    private Integer prod_stock;

    // Relación: Muchos productos pertenecen a una categoría
    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private Categoria categoria;

    // Constructor Vacío
    public Producto() {
    }

    // Constructor con 5 parámetros (Se exluyó prod_id por ser autoincrementable en la base de datos)
    public Producto(String prod_nombre, String prod_imgurl, Double prod_precio, Integer prod_stock, Categoria categoria) {
        this.prod_nombre = prod_nombre;
        this.prod_imgurl = prod_imgurl;
        this.prod_precio = prod_precio;
        this.prod_stock = prod_stock;
        this.categoria = categoria;
    }

    // Getters
    public Integer getProd_id() {
        return prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public String getProd_imgurl() {
        return prod_imgurl;
    }

    public Double getProd_precio() {
        return prod_precio;
    }

    public Integer getProd_stock() {
        return prod_stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Setters
    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public void setProd_imgurl(String prod_imgurl) {
        this.prod_imgurl = prod_imgurl;
    }

    public void setProd_precio(Double prod_precio) {
        this.prod_precio = prod_precio;
    }

    public void setProd_stock(Integer prod_stock) {
        this.prod_stock = prod_stock;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
