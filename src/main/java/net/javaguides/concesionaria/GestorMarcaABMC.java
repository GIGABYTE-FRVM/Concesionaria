package net.javaguides.concesionaria;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Pais;

public class GestorMarcaABMC {

    List<Pais> listaPaises;
    private List<Marca> listaMarcas;
    GestorPaisABMC gestorPais = new GestorPaisABMC(this);
    GestorAutoABMC gestorAuto;
    GestorModeloABMC gestorModelo;
    MarcaABMC pantallaMarca;
    GestorHibernate gestorHibernate = new GestorHibernate();
    Notificador notificador;


    public GestorMarcaABMC() {
        pantallaMarca = new MarcaABMC(this);
        pantallaMarca.setVisible(true);
    }
    
    public void notificarGestorAuto(GestorAutoABMC gestorSubscrito){
        gestorAuto = gestorSubscrito;
    }
    public void notificarGestorModelo(GestorModeloABMC gestorSubscrito){
        gestorModelo = gestorSubscrito;
    }

    public List<Marca> conocerListMarcas() {
        conocerMarcas();
        return listaMarcas;
    }

    public void conocerPaises() {
        if (!(listaPaises == null)) {
            listaPaises.clear();
        }
        listaPaises = gestorPais.conocerListPaises();
    }

    public void modificarMarca() {
        Marca marcaObject = gestorHibernate.getObjectById("Marca",Integer.parseInt(pantallaMarca.getTxtId()));
        marcaObject.setNombre(pantallaMarca.getTxtNombre());
        marcaObject.setCodigo(pantallaMarca.getTxtCodigo());
        marcaObject.setDescripcion(pantallaMarca.getTxtDescripcion());
        marcaObject.setPais(listaPaises.get(pantallaMarca.getPais()));
        if (esValido(marcaObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(marcaObject);
            mostrarDatos();
            pantallaMarca.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void conocerMarcas() {
        listaMarcas = gestorHibernate.getAllObjects("Marca");
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerMarcas();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Pais");
        String data[] = new String[5];
        try {
            for (Marca marca : listaMarcas) {
                data[0] = Integer.toString((int) marca.getId());
                data[1] = marca.getCodigo();
                data[2] = marca.getNombre();
                data[3] = marca.getDescripcion();
                data[4] = marca.getPais().getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void registrarMarca() {
        String codigo = pantallaMarca.getTxtCodigo();
        String nombre = pantallaMarca.getTxtNombre();
        String descripcion = pantallaMarca.getTxtDescripcion();
        Pais pais = listaPaises.get(pantallaMarca.getPais());
        Marca marcaObject = new Marca(codigo, nombre, descripcion, pais);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (esValido(marcaObject, 0)) {
            gestorHibernate.saveObject(marcaObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaMarca.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS. REVISE LA ENTRADA");
        }

    }

    public void eliminarMarca() {
        String id = pantallaMarca.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta marca?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Marca",Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    void mostrarPaisABMC() {
        gestorPais.mostrarPantalla();
        gestorPais.notificarGestor(this);
        solicitarActualizacionPaises();
    }

    void actualizarComboPaises() {
        pantallaMarca.actualizarComboPaises();
    }

    public void mostrarPantalla(boolean visible) {
        pantallaMarca.setVisible(visible);
    }

    public List<Marca> conocerListaMarcas() {
        conocerMarcas();
        return listaMarcas;
    }
    public synchronized void notificarSubscriptores(){
        if (!(gestorAuto == null))
            {        
                gestorAuto.notificarActualizacionMarcas();
            }
        if (!(gestorModelo == null))
            {        
                gestorModelo.notificarActualizacionMarcas();
            }
    }
    synchronized void solicitarActualizacionPaises() {
        notificador = new Notificador();
        new Thread(() -> {
            notificador.solicitar();
        }).start();
    }

    synchronized void notificarActualizacionPaises() {
        new Thread(() -> {
            notificador.entregar();
            conocerPaises();
            pantallaMarca.actualizarComboPaises();
        }).start();
    }

    public boolean esValido(Marca marca, int tipo) {
        if ((marca.getCodigo().length() == 0) || (marca.getNombre().length() == 0) || (marca.getDescripcion().length() == 0)) {
            return false;
        }
        if (tipo == 0) {
            for (Marca marcaOfList : listaMarcas) {
                if (marcaOfList.getNombre().equalsIgnoreCase(marca.getNombre())) {
                    return false;
                }
            }
        }
        return true;
    }

}
