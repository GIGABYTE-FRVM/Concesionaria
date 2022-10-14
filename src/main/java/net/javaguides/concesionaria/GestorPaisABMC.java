package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Pais;

public class GestorPaisABMC {

    private List<Pais> listaPaises;
    PaisABMC pantallaPais;
    GestorHibernate gestorHibernate = new GestorHibernate();
    GestorMarcaABMC gestorMarca;

    
    public GestorPaisABMC(GestorMarcaABMC gestorMarca) {
        pantallaPais = new PaisABMC(this);
    }
    public void conocerGestorMarca(GestorMarcaABMC gestorMarca) {
        this.gestorMarca = gestorMarca;
    }
    
    public void registrarPais() {
        String nombre = pantallaPais.getTxtNombre();
        Pais paisObject = new Pais( nombre);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (((nombre.length() != 0))) {
            gestorHibernate.saveObject(paisObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarPais() {
        Pais paisObject;
        paisObject = gestorHibernate.getObjectById("Pais",Integer.parseInt(pantallaPais.getTxtId()));
        paisObject.setNombre(pantallaPais.getTxtNombre());
        
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(paisObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    
    public void conocerPaises(){
        listaPaises = gestorHibernate.getAllObjects("Pais");
    }
    public List<Pais> conocerListPaises(){
        conocerPaises();
        return listaPaises;
    }
    public DefaultTableModel mostrarDatos() {
        this.conocerPaises();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        String data[] = new String[2];
        try {for(Pais pais : listaPaises){
                data[0] = Integer.toString(pais.getId());
                data[1] = pais.getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarPais(){
        String id = pantallaPais.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este pais?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Pais",Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    public void notificarGestor(GestorMarcaABMC gestorSubscrito){
        gestorMarca = gestorSubscrito;
    }
    public synchronized void notificarSubscriptores(){
        if (!(gestorMarca == null))
            {        
                gestorMarca.notificarActualizacionPaises();
            }
    }
    public void mostrarPantalla() {
        pantallaPais.setVisible(true);
    }
}
