/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package net.javaguides.concesionaria;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Combustible;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Pais;
import net.javaguides.hibernate.model.Region;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class GestorVentaTest {
    
    public GestorVentaTest() {
    }

    @org.junit.Test
    public void testMostrarPantalla() {
    }

    @org.junit.Test
    public void testMostrarConsultasVentas() {
    }

    @org.junit.Test
    public void testConocerVendedores() {
    }

    @org.junit.Test
    public void testGetFechaActual() {
    }

    @org.junit.Test
    public void testGetHoraActual() {
    }

    @org.junit.Test
    public void testMostrarIdUltimaVenta() {
    }

    @org.junit.Test
    public void testConocerUltimoIdVenta() {
    }

    @org.junit.Test
    public void testBuscarClientePorDni() {
    }

    @org.junit.Test
    public void testBuscarAuto() {
    }

    @org.junit.Test
    public void testGetAutoSeleccionado() {
    }

    @org.junit.Test
    public void testSetAutoSeleccionado() {
    }

    @org.junit.Test
    public void testCalcularTotal() {
        //valores precargados
        //int cantidad = 1;
        //double costo = 3000000;
        //double impuesto = 2.3;
        double totalEsperadoVenta = 3069000;
        
        //cargamos la pantalla para probar el metodo
        GestorVenta gestor = new GestorVenta();
        VistaVenta pantallaVenta = new VistaVenta(gestor);
        //cargamos el spinner de la cantidad de autos
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinner = new JSpinner(model);
        System.out.println(spinner.getNextValue());
        pantallaVenta.setTxtCantidad(spinner);
        //definimos un auto con su precio de venta
        Auto auto = new Auto();
        auto.setPrecio(3000000);
        auto.setMarca(new Marca());
        auto.getMarca().setPais(new Pais());
        auto.getMarca().getPais().setRegion(new Region());
        auto.setCombustible(new Combustible());
        
        
        //cargamos el impuesto en la pantalla
        auto.getMarca().getPais().getRegion().setPorcentaje(2.3);
        
        //probamos el metodo con el test
        gestor.setAutoSeleccionado(auto);
        gestor.setPantallaVenta(pantallaVenta);
        
        double totalCalculado = gestor.calcularTotal();
        System.out.println("totalCalculado: " + totalCalculado);
        System.out.println("totalEsperado: " + totalEsperadoVenta);
        assertEquals(totalEsperadoVenta, totalCalculado, 0);
        System.out.println("llego hsta aca");
        
    }

    @org.junit.Test
    public void testRegistrarVenta() {
    }

    @org.junit.Test
    public void testMostrarDatos() {
    }

    @org.junit.Test
    public void testActualizarTabla() {
    }
    
}
