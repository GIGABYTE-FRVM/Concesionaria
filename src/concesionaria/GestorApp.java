/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package concesionaria;

/**
 *
 * @author Usuario
 */
public class GestorApp {

    /**
     * @param args the command line arguments
     */
    static App app;
    
    public static void main(String[] args) {
        // TODO code application logic here
        app = new App();
        app.setVisible(true);
        var gestor = new GestorApp();
        gestor.conocerPantalla();
    }
    
    public void conocerPantalla() {
        app.conocerGestor(this);
    }
    
    public void menuPaisActionPerformed() {
        GestorPaisABMC gestorPais = new GestorPaisABMC();
        gestorPais.mostrarPantalla();
    }
    
    public void menuMarcaActionPerformed() {
        GestorMarcaABMC gestorMarca = new GestorMarcaABMC();
        
    }
}
