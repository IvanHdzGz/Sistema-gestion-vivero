/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 *
 * @author Wyrnm
 */
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

    @EmbeddedId
    private DetalleCompraPK id;

    @ManyToOne
    @MapsId("com_id") // Vincula con el atributo com_id de DetalleCompraPK
    @JoinColumn(name = "com_id")
    private Compra compra;

    @ManyToOne
    @MapsId("prod_id") // Vincula con el atributo prod_id de DetalleCompraPK
    @JoinColumn(name = "prod_id")
    private Producto producto;

    private Integer dc_cantidad;
    private Double dc_costouni;

    public DetalleCompra() {
        this.id = new DetalleCompraPK();
    }

    public DetalleCompra(Compra compra, Producto producto, Integer dc_cantidad, Double dc_costouni) {
        this.id = new DetalleCompraPK(compra.getCom_id(), producto.getProd_id());
        this.compra = compra;
        this.producto = producto;
        this.dc_cantidad = dc_cantidad;
        this.dc_costouni = dc_costouni;
    }

    // Getters
    public DetalleCompraPK getId() {
        return id;
    }

    public Compra getCompra() {
        return compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getDc_cantidad() {
        return dc_cantidad;
    }

    public Double getDc_costouni() {
        return dc_costouni;
    }

    // Setters
    public void setId(DetalleCompraPK id) {
        this.id = id;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setDc_cantidad(Integer dc_cantidad) {
        this.dc_cantidad = dc_cantidad;
    }

    public void setDc_costouni(Double dc_costouni) {
        this.dc_costouni = dc_costouni;
    }
}
