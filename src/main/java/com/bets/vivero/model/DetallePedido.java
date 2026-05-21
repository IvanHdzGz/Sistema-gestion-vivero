/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.Column;
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
@Table(name = "detalle_pedido")
public class DetallePedido {

    @EmbeddedId
    private DetallePedidoPK id = new DetallePedidoPK(); // Inicializarla evita NullPointerException

    @ManyToOne
    @MapsId("pedId") // Vinculado a la PK compuesto
    @JoinColumn(name = "ped_id")
    private Pedido pedido;

    // 1. ELIMINAMOS por completo el campo "private Integer prod_id;" que causaba el choque.
    @ManyToOne
    @MapsId("prodId") // 👈 ¡AGREGA ESTO! Debe coincidir exactamente con el nombre del atributo dentro de tu DetallePedidoPK (ej: prodId)
    @JoinColumn(name = "prod_id")
    private Producto producto;

    @Column(name = "prod_id", insertable = false, updatable = false)
    private Integer prod_id;

    @Column(name = "dp_cantidad")
    private Integer dpCantidad;

    @Column(name = "dp_preciovta")
    private Double dpPreciovta;

    // --- EL SETTER CORREGIDO PARA LLAVE COMPUESTA ---
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        if (pedido != null) {
            // Sincronizamos el ID de la llave compuesta con el ID del pedido
            this.id.setPedId(pedido.getPed_id());
        }
    }

    // --- OTROS GETTERS Y SETTERS ---
    public DetallePedidoPK getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getDpCantidad() {
        return dpCantidad;
    }

    public Double getDpPreciovta() {
        return dpPreciovta;

    }

    public void setId(DetallePedidoPK id) {
        this.id = id;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        if (producto != null) {
            this.id.setProdId(producto.getProd_id()); // Sincronizamos el ID del producto en la PK
        }
    }

    public void setDpCantidad(Integer dpCantidad) {
        this.dpCantidad = dpCantidad;
    }

    public void setDpPreciovta(Double dpPreciovta) {
        this.dpPreciovta = dpPreciovta;
    }

}
