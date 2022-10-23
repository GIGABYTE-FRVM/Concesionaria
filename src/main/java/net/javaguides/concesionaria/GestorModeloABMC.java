package net.javaguides.concesionaria;

import net.javaguides.concesionaria.herramientas.Notificador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;

public class GestorModeloABMC {

    List<Marca> listaMarcas;
    List<Modelo> listaModelos;
    List<Modelo> listaModelosMarca;

    GestorHibernate gestorHibernate;
    GestorMarcaABMC gestorMarca;
    GestorAutoABMC gestorAuto;

    ModeloABMC pantallaModelo;
    Notificador notificador;

    public GestorModeloABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
        gestorMarca = new GestorMarcaABMC();
        pantallaModelo = new ModeloABMC(this);
        gestorMarca.mostrarPantalla(false);
    }

    public void registrarModelo() {
        String nombre = pantallaModelo.getTxtNombre();
        String version = pantallaModelo.getTxtVersion();
        String añoLanzamiento = pantallaModelo.getTxtAñoLanzamiento();
        Marca marca = pantallaModelo.getMarca();
        Modelo modeloObject = new Modelo(nombre, version, añoLanzamiento, marca);
        if (esValido(modeloObject, 0)) {
            gestorHibernate.saveObject(modeloObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaModelo.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarModelo() {
        Modelo modeloObject;
        modeloObject = (Modelo)pantallaModelo.getModelo();
        modeloObject.setNombre(pantallaModelo.getTxtNombre());
        modeloObject.setVersion(pantallaModelo.getTxtVersion());
        modeloObject.setAñoLanzamiento(pantallaModelo.getTxtAñoLanzamiento());
        modeloObject.setMarca(pantallaModelo.getMarca());
        if (esValido(modeloObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(modeloObject);
            mostrarDatos();
            pantallaModelo.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarModelo() {
        Modelo modeloObject = (Modelo)pantallaModelo.getModelo();

        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este modelo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(modeloObject);
            // si selecciona SI (primer boton) ejecuta la eliminacion            
            notificarSubscriptores();

        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerModelos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Version");
        modelo.addColumn("AñoLanzamiento");
        modelo.addColumn("Marca");

        Object data[] = new Object[5];
        try {
            for (Modelo modeloObject : listaModelos) {
                data[0] = modeloObject.getId();
                data[1] = modeloObject;
                data[2] = modeloObject.getVersion();
                data[3] = modeloObject.getAñoLanzamiento();
                data[4] = modeloObject.getMarca().getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void conocerModelos() {
        listaModelos = gestorHibernate.getAllObjects("Modelo");
    }

    public void conocerMarcas() {
        if (!(listaMarcas == null)) {
            listaMarcas.clear();
        }
        listaMarcas = gestorMarca.conocerListMarcas();
    }

    public List<Modelo> conocerListaModelos() {
        conocerModelos();
        return listaModelos;
    }

    public List<Modelo> conocerModelosDeMarca(Marca marca) {
        listaModelosMarca = gestorHibernate.getAllObjects("Modelo WHERE id_marca=" + marca.getId());
        return listaModelosMarca;
    }

    public void mostrarPantalla(boolean visible) {
        pantallaModelo.setVisible(visible);
    }

    public void suscribirGestor(GestorAutoABMC gestorSubscrito) {
        gestorAuto = gestorSubscrito;
    }

    synchronized void solicitarActualizacionMarcas() {
        notificador = new Notificador();
        new Thread(() -> {
            notificador.solicitar();
        }).start();
    }

    synchronized void notificarActualizacionMarcas() {
        new Thread(() -> {
            notificador.entregar();
            conocerMarcas();
            pantallaModelo.actualizarComboMarcas();
        }).start();
    }

    public synchronized void notificarSubscriptores() {
        if (!(gestorAuto == null)) {
            gestorAuto.notificarActualizacionModelo();
        }
    }

    public boolean esValido(Modelo modelo, int tipo) {
        if ((modelo.getVersion().length() == 0) || (modelo.getNombre().length() == 0) || (modelo.getAñoLanzamiento().length() == 0)) {
            return false;
        }
        if (tipo == 0) {
            for (Modelo modeloOfList : listaModelos) {
                if (modeloOfList.getNombre().equalsIgnoreCase(modelo.getNombre())) {
                    return false;
                }
            }
        }
        return true;
    }

    void mostrarMarcaABMC() {
        gestorMarca.mostrarPantalla(true);
        gestorMarca.suscribirGestorModelo(this);
        solicitarActualizacionMarcas();
    }
}
