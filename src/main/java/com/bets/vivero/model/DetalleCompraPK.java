/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bets.vivero.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Wyrnm
 */
@Embeddable
public class DetalleCompraPK implements Serializable {

    private Integer com_id;
    private Integer prod_id;

    // Constructor vacío
    public DetalleCompraPK() {
    }

    // Constructor con dos parámetros
    public DetalleCompraPK(Integer com_id, Integer prod_id) {
        this.com_id = com_id;
        this.prod_id = prod_id;
    }

    // Getters
    public Integer getCom_id() {
        return com_id;
    }

    public Integer getProd_id() {
        return prod_id;
    }

    // Setters
    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    //HashCode y Equals son obligatorios para llaves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DetalleCompraPK that = (DetalleCompraPK) o;
        return Objects.equals(com_id, that.com_id) && Objects.equals(prod_id, that.prod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(com_id, prod_id);
    }
}
