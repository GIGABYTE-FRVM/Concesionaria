/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package net.javaguides.concesionaria;

/**
 *
 * @author Usuario
 */
public class GestorApp {

    /**
     * @param args the command line arguments
     */
    static App app;
    GestorMarcaABMC gestorMarca;
    GestorAutoABMC gestorAuto;
    GestorPaisABMC gestorPais;
    GestorPersonalABMC gestorPersonal;
    GestorModeloABMC gestorModelo;
    GestorClienteABMC gestorCliente;
    GestorVenta gestorVenta;

    public static void main(String[] args) {
        // TODO code application logic here
        app = new App();
        app.setVisible(true);
        var gestor = new GestorApp();
        gestor.conocerPantalla();
    }

    public void conocerPantalla() {
        app.conocergestor(this);
    }

    public void menuPaisActionPerformed() {
        menuMarcaActionPerformed();
        gestorMarca.mostrarPantalla(false);
        gestorPais = new GestorPaisABMC();
        gestorPais.mostrarPantalla();
    }

    public void menuPersonalActionPerformed() {
        gestorPersonal = new GestorPersonalABMC();
        gestorPersonal.mostrarPantalla();
    }

    public void menuClienteActionPerformed() {
        gestorCliente = new GestorClienteABMC();
        gestorCliente.mostrarPantalla();
    }

    public void menuMarcaActionPerformed() {
        gestorMarca = new GestorMarcaABMC();
        gestorMarca.mostrarPantalla(true);

    }

    public void menuAutoActionPerformed() {
        this.gestorAuto = new GestorAutoABMC();
        gestorAuto.mostrarPantalla(true);
    }

    public void menuCombustibleActionPerformed() {
        GestorCombustibleABMC gestorCombustible = new GestorCombustibleABMC();
        gestorCombustible.mostrarPantalla(true);
    }

    void menuModeloActionPerformed() {
        this.gestorModelo = new GestorModeloABMC();
        gestorModelo.mostrarPantalla(true);
    }

    public void crearGestorVenta() {
        gestorVenta = new GestorVenta();
        gestorVenta.mostrarPantalla(true);

    }
}
