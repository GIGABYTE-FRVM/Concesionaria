package net.javaguides.concesionaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.CombustibleDao;
import net.javaguides.hibernate.model.Combustible;

public class GestorCombustibleABMC {

    private List<Combustible> listaCombustible;
    CombustibleABMC pantallaCombustible;
    CombustibleDao combustibleDao = new CombustibleDao();

   
    public GestorCombustibleABMC() {
        pantallaCombustible = new CombustibleABMC(this);
    }

    GestorCombustibleABMC(GestorAutoABMC aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void registrarCombustible() {
        String nombre = pantallaCombustible.getTxtNombre();
        Combustible combustibleObject = new Combustible( nombre);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (esValido(combustibleObject)) {
            combustibleDao.saveCombustible(combustibleObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarCombustible() {
        Combustible combustibleObject;
        combustibleObject = combustibleDao.getCombustibleById(Integer.parseInt(pantallaCombustible.getTxtId()));
        combustibleObject.setNombre(pantallaCombustible.getTxtNombre());
        
        
        if (esValido(combustibleObject)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            combustibleDao.updateCombustible(combustibleObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    
    public void conocerCombustibles(){
        listaCombustible = combustibleDao.getAllCombustible();
    }
    public List<Combustible> conocerListaCombustibles(){
        conocerCombustibles();
        return listaCombustible;
    }
    public DefaultTableModel mostrarDatos() {
        this.conocerCombustibles();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        String data[] = new String[2];
        try {for(Combustible combustible : listaCombustible){
                data[0] = Integer.toString(combustible.getId());
                data[1] = combustible.getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarCombustible(){
        String id = pantallaCombustible.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este combustible?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            combustibleDao.deleteCombustible(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    public List<Combustible> conocerListaCombustible(){
        conocerCombustibles();
        return listaCombustible;
    }
    public void mostrarPantalla(boolean visible) {
        pantallaCombustible.setVisible(visible);
    }
    public boolean esValido(Combustible combustible){
        if(combustible.getNombre().length() == 0){
            return false;
        }for(Combustible combustibleOfList : listaCombustible){
            if(combustibleOfList.getNombre().equalsIgnoreCase(combustible.getNombre())){
                return false;
            }
        }
        return true;
    }
}
