package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Pais;

public class GestorPaisABMC {

    private List<Pais> listaPaises;

    GestorHibernate gestorHibernate;
    GestorMarcaABMC gestorMarca;

    PaisABMC pantallaPais;

    public GestorPaisABMC(GestorMarcaABMC gestorMarca) {
        gestorHibernate = new GestorHibernate();
        pantallaPais = new PaisABMC(this);
    }

    public void registrarPais() {
        String nombre = pantallaPais.getTxtNombre();
        Pais paisObject = new Pais(nombre);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (esValido(paisObject,0)) {
            gestorHibernate.saveObject(paisObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarPais() {
        Pais paisObject;
        paisObject = gestorHibernate.getObjectById("Pais", Integer.parseInt(pantallaPais.getTxtId()));
        paisObject.setNombre(pantallaPais.getTxtNombre());

        if (esValido(paisObject,1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(paisObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarPais() {
        String id = pantallaPais.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este pais?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Pais", Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerPaises();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        String data[] = new String[2];
        try {
            for (Pais pais : listaPaises) {
                data[0] = Integer.toString(pais.getId());
                data[1] = pais.getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void conocerGestorMarca(GestorMarcaABMC gestorMarca) {
        this.gestorMarca = gestorMarca;
    }

    public void conocerPaises() {
        listaPaises = gestorHibernate.getAllObjects("Pais");
    }

    public List<Pais> conocerListPaises() {
        conocerPaises();
        return listaPaises;
    }

    public synchronized void notificarSubscriptores() {
        if (!(gestorMarca == null)) {
            gestorMarca.notificarActualizacionPaises();
        }
    }

    public void notificarGestor(GestorMarcaABMC gestorSubscrito) {
        gestorMarca = gestorSubscrito;
    }

    public boolean esValido(Pais pais, int tipo) {
        if (pais.getNombre().length() == 0) {
            return false;
        }
        if (tipo == 0) {
            for (Pais paisOfList : listaPaises) {
                if (paisOfList.getNombre().equalsIgnoreCase(pais.getNombre())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarPantalla() {
        pantallaPais.setVisible(true);
    }
}
