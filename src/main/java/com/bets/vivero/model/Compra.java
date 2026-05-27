/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Wyrnm
 */
@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer com_id;

    @ManyToOne
    @JoinColumn(name = "prov_id", nullable = false)
    private Proveedor proveedor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date com_fecha;

    private Double com_total;

    // Relación inversa para acceder a los productos de esta compra
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleCompra> detalles;

    // Constructor con 1 parámetro
    public Compra() {
        this.com_fecha = new Date();
    }

    // Constructor con 2 parámetros
    public Compra(Proveedor proveedor, Double com_total) {
        this.proveedor = proveedor;
        this.com_total = com_total;
        this.com_fecha = new Date();
    }

    // Getters
    public Integer getCom_id() {
        return com_id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Date getCom_fecha() {
        return com_fecha;
    }

    public Double getCom_total() {
        return com_total;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    // Setters
    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setCom_fecha(Date com_fecha) {
        this.com_fecha = com_fecha;
    }

    public void setCom_total(Double com_total) {
        this.com_total = com_total;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

}
