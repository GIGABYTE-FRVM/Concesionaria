package net.javaguides.concesionaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.PaisDao;
import net.javaguides.hibernate.model.Pais;

public class GestorPaisABMC {

    private List<Pais> listaPaises;
    PaisABMC pantallaPais;
    PaisDao paisDao = new PaisDao();

    
    public GestorPaisABMC() {
        pantallaPais = new PaisABMC(this);
    }
    
    public void registrarPais() {
        String nombre = pantallaPais.getTxtNombre();
        Pais paisObject = new Pais( nombre);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (((nombre.length() != 0))) {
            paisDao.savePais(paisObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarPais() {
        Pais paisObject;
        paisObject = paisDao.getPaisById(Integer.parseInt(pantallaPais.getTxtId()));
        paisObject.setNombre(pantallaPais.getTxtNombre());
        
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            paisDao.updatePais(paisObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    public List<Pais> conocerPaises(){
        conocerPais();
        return listaPaises;
    }
    public void conocerPais(){
        listaPaises = paisDao.getAllPais();
    }
    public DefaultTableModel mostrarDatos() {
        this.conocerPais();
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
            paisDao.deletePais(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    
    public void mostrarPantalla() {
        pantallaPais.setVisible(true);
    }
}
