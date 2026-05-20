/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Wyrnm
 */
@Embeddable
public class DetallePedidoPK implements Serializable {

    @Column(name = "ped_id")
    private Integer pedId;

    @Column(name = "prod_id")
    private Integer prodId;

    public DetallePedidoPK() {
    }

    public DetallePedidoPK(Integer pedId, Integer prodId) {
        this.pedId = pedId;
        this.prodId = prodId;
    }

    public Integer getPedId() {
        return pedId;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setPedId(Integer pedId) {
        this.pedId = pedId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    // Otros métodos
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DetallePedidoPK that = (DetallePedidoPK) o;
        return Objects.equals(pedId, that.pedId) && Objects.equals(prodId, that.prodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedId, prodId);
    }
}
