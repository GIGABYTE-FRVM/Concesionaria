/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.concesionaria.herramientas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.javaguides.concesionaria.GestorVenta;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Venta;

/**
 *
 * @author matya
 */
public class GestorBuscador {

    Buscador pantallaBuscador;
    GestorHibernate gestorHibernate;
    List<Auto> listaAutos;
    List<Auto> autosFiltrados;
    GestorVenta gestorVenta;

    public static void main(String[] args) {
        var gestor = new GestorBuscador();
    }

    public GestorBuscador() {
        gestorHibernate = GestorHibernate.getInstancia();
        this.pantallaBuscador = new Buscador(this);
        mostrarPantalla(true);
    }

    public DefaultTableModel mostrarDatos(List<Auto> listaAutos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año Fabricacion");
        modelo.addColumn("Combustible");
        modelo.addColumn("Color");
        modelo.addColumn("Precio");
        Object data[] = new Object[7];
        try {
            for (Auto auto : listaAutos) {
                data[0] = auto;
                data[1] = auto.getMarca().getNombre();
                data[2] = auto.getModelo().getNombre();
                data[3] = Integer.toString(auto.getAñoFabricacion());
                data[4] = auto.getCombustible().getNombre();
                data[5] = auto.getColor();
                data[6] = Double.toString(auto.getPrecio());

                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos: " + e);
        }
        return modelo;
    }
    
    public void conocerGestorAuto(GestorVenta gestorVenta){
        this.gestorVenta = gestorVenta;
    }

    private void conocerAutos() {
        listaAutos = gestorHibernate.getAllObjects("Auto");
    }

    public DefaultTableModel buscarAutos() {
        String tipo = pantallaBuscador.getTipo();
        String consulta = pantallaBuscador.getConsulta();
        switch (tipo) {
            case "Año":
                autosFiltrados = gestorHibernate.getAllObjects("Auto WHERE añoFabricacion = " + consulta);
                break;
            case "Color":
                autosFiltrados = gestorHibernate.getAllObjects("Auto WHERE color LIKE '%" + consulta + "%'");
                break;
            case "Combustible":
                autosFiltrados = gestorHibernate.getAllObjects("Auto as auto WHERE auto.combustible.nombre  LIKE '%" + consulta + "%'");
                break;
            case "Modelo":
                autosFiltrados = gestorHibernate.getAllObjects("Auto as auto WHERE auto.modelo.nombre  LIKE '%" + consulta + "%'");
                break;
            case "Marca":
                autosFiltrados = gestorHibernate.getAllObjects("Auto as auto WHERE auto.marca.nombre  LIKE '%" + consulta + "%'");
                break;
            case "Version":
                autosFiltrados = gestorHibernate.getAllObjects("Auto WHERE version = " + consulta);
                break;
            default:
                autosFiltrados = listaAutos;
        }
        return mostrarDatos(autosFiltrados);
    }

    public DefaultTableModel mostrarAutos() {
        this.conocerAutos();
        return mostrarDatos(listaAutos);
    }

    void mostrarPantalla(Boolean visible) {
        pantallaBuscador.setVisible(visible);
    }
    void tomarSeleccion(Auto autoSeleccionado){
        gestorVenta.setAutoSeleccionado(autoSeleccionado);
    }
    
    
    public List<Auto> conocerAutosLimit(int page, int limit) {
        listaAutos = gestorHibernate.getObjectsLimit("Auto", page, limit);
        return listaAutos;
    }

}
