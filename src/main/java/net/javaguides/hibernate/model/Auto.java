/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auto")

public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "anioFabricacion")
    private int añoFabricacion;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_combustible", referencedColumnName = "id")
    private Combustible combustible;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_modelo", referencedColumnName = "id")
    private Modelo modelo;

    @Column(name = "precio")
    double precio;
    
    @Column(name = "precio_costo")
    double precioCosto;

    public Auto(int añoFabricacion, String color, Combustible combustible, Marca marca, Modelo modelo, double precio, double precioCosto) {
        this.añoFabricacion = añoFabricacion;
        this.color = color;
        this.combustible = combustible;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.precioCosto = precioCosto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Auto() {
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public String toStringCompleto() {
        return this.marca + " " + this.modelo + " " + añoFabricacion;
    }
    
}
