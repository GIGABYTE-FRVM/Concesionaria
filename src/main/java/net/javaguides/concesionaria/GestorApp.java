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

    
    public static void main(String[] args) {
        // TODO code application logic here
        app = new App();
        app.setVisible(true);
        var gestor = new GestorApp();
        gestor.conocerPantalla();
        
    }

    public GestorApp() {
        
    }
    
    public void conocerPantalla() {
        app.conocerGestor(this);
    }
    
    public void menuPaisActionPerformed() {
        menuMarcaActionPerformed();
        gestorMarca.mostrarPantalla(false);
        this.gestorPais = new GestorPaisABMC(gestorMarca);
        gestorPais.mostrarPantalla();
    }
    
    public void menuMarcaActionPerformed() {
        this.gestorMarca = new GestorMarcaABMC();
        gestorMarca.mostrarPantalla(true); 
    }
    public void menuAutoActionPerformed() {
        this.gestorAuto = new GestorAutoABMC();
        gestorAuto.mostrarPantalla(true); 
    }
    
    public void menuCombustibleActionPerformed() {
        GestorCombustibleABMC gestorCombustible = new GestorCombustibleABMC();
        gestorCombustible.mostrarPantalla();
    }

    void menuModeloActionPerformed() {
        GestorModeloABMC gestorModelo = new GestorModeloABMC();
        gestorModelo.mostrarPantalla();
    }
}
