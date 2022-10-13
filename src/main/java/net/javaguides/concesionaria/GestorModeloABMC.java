package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;

public class GestorModeloABMC{

    List<Marca> listaMarcas;
    private List<Modelo> listaModelos;
    private List<Modelo> listaModelosMarca;
    ModeloABMC pantallaModelo;
    GestorHibernate gestorHibernate = new GestorHibernate();
    GestorMarcaABMC gestorMarca;
    GestorAutoABMC gestorAuto;
    Notificador notificador;

    public GestorModeloABMC() {
        gestorMarca = new GestorMarcaABMC();
        gestorMarca.mostrarPantalla(false);
        pantallaModelo = new ModeloABMC(this);
    }

    public void registrarModelo() {
        String nombre = pantallaModelo.getTxtNombre();
        String version = pantallaModelo.getTxtVersion();
        String añoLanzamiento = pantallaModelo.getTxtAñoLanzamiento();
        Marca marca = listaMarcas.get(pantallaModelo.getMarca());
        Modelo modeloObject = new Modelo(nombre, version, añoLanzamiento, marca);
        //ps.setString(4, cboModelo.getSelectedItem().toString());
        if (esValido(modeloObject, 0)) {
            gestorHibernate.saveObject(modeloObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            notificarSubscriptores();

            pantallaModelo.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarModelo() {
        Modelo modeloObject;
        modeloObject = gestorHibernate.getObjectById("Modelo", Integer.parseInt(pantallaModelo.getTxtId()));
        modeloObject.setNombre(pantallaModelo.getTxtNombre());
        modeloObject.setVersion(pantallaModelo.getTxtVersion());
        modeloObject.setAñoLanzamiento(pantallaModelo.getTxtAñoLanzamiento());
        modeloObject.setMarca(listaMarcas.get(pantallaModelo.getMarca()));
        if (esValido(modeloObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(modeloObject);
            mostrarDatos();
            notificarSubscriptores();

            pantallaModelo.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    ;
    
    public void conocerModelos() {
        listaModelos = gestorHibernate.getAllObjects("Modelo");
    }

    public List<Modelo> conocerListModelos() {
        conocerModelos();
        return listaModelos;
    }

    public void conocerMarcas() {
        if (!(listaMarcas == null)) {
            listaMarcas.clear();
        }
        listaMarcas = gestorMarca.conocerListMarcas();
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerModelos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Version");
        modelo.addColumn("AñoLanzamiento");
        modelo.addColumn("Marca");

        String data[] = new String[5];
        try {
            for (Modelo modeloObject : listaModelos) {
                data[0] = Integer.toString((int) modeloObject.getId());
                data[1] = modeloObject.getNombre();
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

    public void eliminarModelo() {
        String id = pantallaModelo.getTxtId();
        String nombre = pantallaModelo.getTxtNombre();
        String version = pantallaModelo.getTxtVersion();
        String añoLanzamiento = pantallaModelo.getTxtAñoLanzamiento();

        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este modelo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Modelo", Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion            
            notificarSubscriptores();

        } else {
            //No hace nada
        }
    }

    public List<Modelo> conocerListaModelos() {
        conocerModelos();
        return listaModelos;
    }

    public List<Modelo> conocerModelosDeMarca(Marca marca) {
        listaModelosMarca = gestorHibernate.getAllObjects("Modelo WHERE id_marca=" + marca.getId());
        return listaModelosMarca;
    }

    void mostrarMarcaABMC() {
        gestorMarca.mostrarPantalla(true);
        gestorMarca.notificarGestorModelo(this);
        solicitarActualizacionMarcas();
    }

    void actualizarComboPaises() {
        pantallaModelo.actualizarComboMarcas();
    }

    public void mostrarPantalla(boolean visible) {
        pantallaModelo.setVisible(visible);
    }

    public void notificarGestor(GestorAutoABMC gestorSubscrito) {
        gestorAuto = gestorSubscrito;
    }

    public synchronized void notificarSubscriptores() {
        if (!(gestorAuto == null)) {
            gestorAuto.notificarActualizacionModelo();
        }
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
}
