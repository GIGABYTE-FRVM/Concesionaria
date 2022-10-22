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

    GestorPaisABMC gestorPais;
    GestorAutoABMC gestorAuto;
    GestorModeloABMC gestorModelo;
    GestorHibernate gestorHibernate;

    MarcaABMC pantallaMarca;
    Notificador notificador;

    public GestorMarcaABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
        gestorPais = new GestorPaisABMC();
        pantallaMarca = new MarcaABMC(this);
        pantallaMarca.setVisible(true);
    }

    public void registrarMarca() {
        String codigo = pantallaMarca.getTxtCodigo();
        String nombre = pantallaMarca.getTxtNombre();
        String descripcion = pantallaMarca.getTxtDescripcion();
        Pais pais = pantallaMarca.getPais();
        Marca marcaObject = new Marca(codigo, nombre, descripcion, pais);
        if (esValido(marcaObject, 0)) {
            gestorHibernate.saveObject(marcaObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaMarca.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS. REVISE LA ENTRADA");
        }
    }

    public void modificarMarca() {
        Marca marcaObject = pantallaMarca.getMarca();
        marcaObject.setNombre(pantallaMarca.getTxtNombre());
        marcaObject.setCodigo(pantallaMarca.getTxtCodigo());
        marcaObject.setDescripcion(pantallaMarca.getTxtDescripcion());
        marcaObject.setPais(pantallaMarca.getPais());
        if (esValido(marcaObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(marcaObject);
            pantallaMarca.limpiarEntradas();
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarMarca() {
        Marca marcaObject = pantallaMarca.getMarca();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta marca?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(marcaObject);
            JOptionPane.showMessageDialog(null, "MARCA ELIMINADA CORRECTAMENTE");
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerMarcas();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Pais");
        Object data[] = new Object[5];
        try {
            for (Marca marca : listaMarcas) {
                data[0] = marca.getId();
                data[1] = marca.getCodigo();
                data[2] = marca;
                data[3] = marca.getDescripcion();
                data[4] = marca.getPais().getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
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

    public void conocerMarcas() {
        listaMarcas = gestorHibernate.getAllObjects("Marca");
    }

    public List<Marca> conocerListaMarcas() {
        conocerMarcas();
        return listaMarcas;
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

    public synchronized void notificarSubscriptores() {
        if (!(gestorAuto == null)) {
            gestorAuto.notificarActualizacionMarcas();
        }
        if (!(gestorModelo == null)) {
            gestorModelo.notificarActualizacionMarcas();
        }
    }

    public void suscribirGestorAuto(GestorAutoABMC gestorSubscrito) {
        gestorAuto = gestorSubscrito;
    }

    public void suscribirGestorModelo(GestorModeloABMC gestorSubscrito) {
        gestorModelo = gestorSubscrito;
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

    void actualizarComboPaises() {
        pantallaMarca.actualizarComboPaises();
    }

    void mostrarPaisABMC() {
        gestorPais.mostrarPantalla();
        gestorPais.notificarGestor(this);
        solicitarActualizacionPaises();
    }

    public void mostrarPantalla(boolean visible) {
        pantallaMarca.setVisible(visible);
    }

}
