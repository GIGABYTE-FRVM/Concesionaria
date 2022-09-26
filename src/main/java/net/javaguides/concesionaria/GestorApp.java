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
        app.conocergestor(this);
    }
    
    public void menuPaisActionPerformed() {
        menuMarcaActionPerformed();
        gestorMarca.mostrarPantalla(false);
        this.gestorPais = new GestorPaisABMC(gestorMarca);
        gestorPais.mostrarPantalla();
    }
    
    public void menuPersonalActionPerformed() {
        GestorPersonalABMC gestorPersonal = new GestorPersonalABMC();
        gestorPersonal.mostrarPantalla();
    }
    
    public void menuMarcaActionPerformed() {
<<<<<<< HEAD
        GestorMarcaABMC gestorMarca = new GestorMarcaABMC();
<<<<<<< HEAD
=======
        //gestorMarca.mostrarPantalla(); 
=======
        this.gestorMarca = new GestorMarcaABMC();
        gestorMarca.mostrarPantalla(true); 
>>>>>>> 4659c05 (Fix cboPaises)
    }
    
    public void menuCombustibleActionPerformed() {
        GestorCombustibleABMC gestorCombustible = new GestorCombustibleABMC();
        gestorCombustible.mostrarPantalla();
>>>>>>> 0462010 (add abmc combustible)
    }
}
