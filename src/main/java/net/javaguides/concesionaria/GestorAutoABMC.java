package net.javaguides.concesionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;
import net.javaguides.hibernate.model.Combustible;

public class GestorAutoABMC {

    List<Marca> listaMarcas;
    List<Modelo> listaModelos;
    List<Combustible> listaCombustibles;
    List<Auto> listaAutos;

    GestorMarcaABMC gestorMarca;
    GestorModeloABMC gestorModelo;
    GestorCombustibleABMC gestorCombustible;

    AutoABMC pantallaAuto;
    GestorHibernate gestorHibernate;
    Notificador notificador;

    public GestorAutoABMC() {
        gestorHibernate = new GestorHibernate();
        gestorCombustible = new GestorCombustibleABMC();
        gestorModelo = new GestorModeloABMC();
        gestorMarca = new GestorMarcaABMC();
        pantallaAuto = new AutoABMC(this);
        gestorMarca.mostrarPantalla(false);
        gestorModelo.mostrarPantalla(false);
        gestorCombustible.mostrarPantalla(false);
    }

    public void registrarAuto() {
        Auto autoObject = new Auto();
        autoObject.setPrecio(Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setModelo(listaModelos.get(pantallaAuto.getModelo()));
        autoObject.setMarca(listaMarcas.get(pantallaAuto.getMarca()));
        autoObject.setCombustible(listaCombustibles.get(pantallaAuto.getCombustible()));
        autoObject.setColor(pantallaAuto.getColor());
        if (esValido(autoObject)) {
            gestorHibernate.saveObject(autoObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarAuto() {
        Auto autoObject = gestorHibernate.getObjectById("Auto", Integer.parseInt(pantallaAuto.getTxtId()));
        autoObject.setPrecio(Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setModelo(listaModelos.get(pantallaAuto.getModelo()));
        autoObject.setMarca(listaMarcas.get(pantallaAuto.getMarca()));
        autoObject.setCombustible(listaCombustibles.get(pantallaAuto.getCombustible()));
        autoObject.setColor(pantallaAuto.getColor());
        if (esValido(autoObject)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(autoObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarAuto() {
        String id = pantallaAuto.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta auto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Auto", Integer.parseInt(id));
            JOptionPane.showMessageDialog(null, "AUTO ELIMINADO CORRECTAMENTE");
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerAutos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año Fabricacion");
        modelo.addColumn("Combustible");
        modelo.addColumn("Color");
        modelo.addColumn("Precio");
        String data[] = new String[7];
        try {
            for (Auto auto : listaAutos) {
                data[0] = Integer.toString((int) auto.getId());
                data[1] = auto.getMarca().getNombre();
                data[2] = auto.getModelo().getNombre();
                data[3] = Integer.toString(auto.getAñoFabricacion());
                data[4] = auto.getCombustible().getNombre();
                data[5] = auto.getColor();
                data[6] = Double.toString(auto.getPrecio());

                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos: " + e);
        }
        return modelo;
    }

    public void conocerMarcas() {
        if (!(listaMarcas == null)) {
            listaMarcas.clear();
        }
        listaMarcas = gestorMarca.conocerListaMarcas();
    }

    public void conocerModelos() {
        if (!(listaModelos == null)) {
            listaModelos.clear();
        }
        try {
            if (!(pantallaAuto == null)) {
                listaModelos = gestorModelo.conocerModelosDeMarca(listaMarcas.get(pantallaAuto.getMarca()));
            } else {
                listaModelos = gestorModelo.conocerListaModelos();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void conocerCombustibles() {
        if (!(listaCombustibles == null)) {
            listaCombustibles.clear();
        }
        listaCombustibles = gestorCombustible.conocerListaCombustibles();
    }

    public void conocerAutos() {
        listaAutos = gestorHibernate.getAllObjects("Auto");
    }

    synchronized void solicitarActualizacion() {
        notificador = new Notificador();
        new Thread(() -> {
            notificador.solicitar();
        }).start();
    }

    synchronized void notificarActualizacionMarcas() {
        new Thread(() -> {
            notificador.entregar();
            conocerMarcas();
            pantallaAuto.actualizarComboMarca();
        }).start();
    }

    synchronized void notificarActualizacionModelo() {
        new Thread(() -> {
            notificador.entregar();
            conocerModelos();
            pantallaAuto.actualizarComboModelo();
        }).start();
    }

    synchronized void notificarActualizacionCombustible() {
        new Thread(() -> {
            notificador.entregar();
            conocerCombustibles();
            pantallaAuto.actualizarComboCombustible();
        }).start();
    }

    public boolean esValido(Auto auto) {
        if ((auto.getPrecio() <= 0) || (auto.getAñoFabricacion() <= 0)) {
            return false;
        }
        return true;
    }

    public void mostrarMarcaABMC() throws InterruptedException {
        gestorMarca.mostrarPantalla(true);
        gestorMarca.notificarGestorAuto(this);
        solicitarActualizacion();
    }

    void mostrarModeloABMC() {
        gestorModelo.mostrarPantalla(true);
        gestorModelo.notificarGestor(this);
        solicitarActualizacion();
    }

    void mostrarCombustibleABMC() {
        gestorCombustible.notificarGestor(this);
        solicitarActualizacion();
        gestorCombustible.mostrarPantalla(true);
    }

    public void mostrarPantalla(boolean visible) {
        pantallaAuto.setVisible(visible);
    }
}
