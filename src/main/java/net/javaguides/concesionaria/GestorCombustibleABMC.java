package net.javaguides.concesionaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Combustible;

public class GestorCombustibleABMC {

    private List<Combustible> listaCombustible;

    GestorHibernate gestorHibernate;
    GestorAutoABMC gestorAuto;

    CombustibleABMC pantallaCombustible;

    public GestorCombustibleABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaCombustible = new CombustibleABMC(this);
    }

    public void registrarCombustible() {
        String nombre = pantallaCombustible.getTxtNombre();
        Combustible combustibleObject = new Combustible(nombre);
        if (esValido(combustibleObject, 0)) {
            gestorHibernate.saveObject(combustibleObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarCombustible() {
        Combustible combustibleObject;
        combustibleObject = gestorHibernate.getObjectById("Combustible", Integer.parseInt(pantallaCombustible.getTxtId()));
        combustibleObject.setNombre(pantallaCombustible.getTxtNombre());
        if (esValido(combustibleObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(combustibleObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarCombustible() {
        String id = pantallaCombustible.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este combustible?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Combustible", Integer.parseInt(id));

            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerCombustibles();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        String data[] = new String[2];
        try {
            for (Combustible combustible : listaCombustible) {
                data[0] = Integer.toString(combustible.getId());
                data[1] = combustible.getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void conocerCombustibles() {
        listaCombustible = gestorHibernate.getAllObjects("Combustible");
    }

    public List<Combustible> conocerListaCombustibles() {
        conocerCombustibles();
        return listaCombustible;
    }

    public synchronized void notificarSubscriptores() {
        if (!(gestorAuto == null)) {
            gestorAuto.notificarActualizacionCombustible();
        }
    }
    
    public void notificarGestor(GestorAutoABMC gestorSubscrito) {
        gestorAuto = gestorSubscrito;
    }

    public boolean esValido(Combustible combustible, int tipo) {
        if (combustible.getNombre().length() == 0) {
            return false;
        }
        if (tipo == 0) {
            for (Combustible combustibleOfList : listaCombustible) {
                if (combustibleOfList.getNombre().equalsIgnoreCase(combustible.getNombre())) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void mostrarPantalla(boolean visible) {
        pantallaCombustible.setVisible(visible);
    }
}
