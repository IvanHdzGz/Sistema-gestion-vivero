/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ped_id;

    @ManyToOne
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ped_fecha;

    @Column(name = "ped_estado", length = 50)
    private String ped_estado;

    @Column(name = "ped_total")
    private Double ped_total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;

    // Constructor vacío
    public Pedido() {
        this.ped_fecha = new Date();
    }

    // Constructor 7 parámetros
    public Pedido(Integer ped_id, Usuario usuario, Cliente cliente, Date ped_fecha, String ped_estado, Double ped_total, List<DetallePedido> detalles) {
        this.ped_id = ped_id;
        this.usuario = usuario;
        this.cliente = cliente;
        this.ped_fecha = ped_fecha;
        this.ped_estado = ped_estado;
        this.ped_total = ped_total;
        this.detalles = detalles;
    }

    // Getters
    public Integer getPed_id() {
        return ped_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getPed_fecha() {
        return ped_fecha;
    }

    public String getPed_estado() {
        return ped_estado;
    }

    public Double getPed_total() {
        return ped_total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    // Setters
    public void setPed_id(Integer ped_id) {
        this.ped_id = ped_id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPed_fecha(Date ped_fecha) {
        this.ped_fecha = ped_fecha;
    }

    public void setPed_estado(String ped_estado) {
        this.ped_estado = ped_estado;
    }

    public void setPed_total(Double ped_total) {
        this.ped_total = ped_total;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}
