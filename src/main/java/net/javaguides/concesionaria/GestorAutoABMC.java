package net.javaguides.concesionaria;

import java.awt.Color;
import net.javaguides.concesionaria.herramientas.Notificador;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;
import net.javaguides.hibernate.model.Combustible;

public class GestorAutoABMC {

    private int ultimoIdAuto;
    List<Marca> listaMarcas;
    List<Modelo> listaModelos;
    List<Combustible> listaCombustibles;
    List<Auto> listaAutos;

    GestorMarcaABMC gestorMarca;
    GestorModeloABMC gestorModelo;
    GestorCombustibleABMC gestorCombustible;
    GestorHibernate gestorHibernate;

    AutoABMC pantallaAuto;
    Notificador notificador;
    Color disableColor = new Color(153,153,153);

    public GestorAutoABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
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
        autoObject.setPrecio(pantallaAuto.getTxtPrecio().length() == 0 ? 0 : Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(pantallaAuto.getTxtAñoFabricacion().length() == 0 ? 0 : Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setPrecioCosto(pantallaAuto.getTxtPrecioCosto().length() == 0 ? 0 : Double.parseDouble(pantallaAuto.getTxtPrecioCosto()));
        autoObject.setModelo(pantallaAuto.getModelo());
        autoObject.setMarca(pantallaAuto.getMarca());
        autoObject.setCombustible(pantallaAuto.getCombustible());
        autoObject.setColor(pantallaAuto.getColor());
        if (esValido(autoObject)) {
            gestorHibernate.saveObject(autoObject);
            pantallaAuto.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaAuto.limpiarEntradas();
        } else {
            pantallaAuto.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
        pantallaAuto.setAlwaysOnTop(true);

    }

    public void modificarAuto() {
        Auto autoObject = pantallaAuto.getAuto();
        autoObject.setPrecio(pantallaAuto.getTxtPrecio().length() == 0 ? 0 : Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(pantallaAuto.getTxtAñoFabricacion().length() == 0 ? 0 : Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setPrecioCosto(pantallaAuto.getTxtPrecioCosto().length() == 0 ? 0 : Double.parseDouble(pantallaAuto.getTxtPrecioCosto()));
        autoObject.setModelo(pantallaAuto.getModelo());
        autoObject.setMarca(pantallaAuto.getMarca());
        autoObject.setCombustible(pantallaAuto.getCombustible());
        autoObject.setColor(pantallaAuto.getColor());
        if (esValido(autoObject)) {
            pantallaAuto.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(autoObject);
            pantallaAuto.limpiarEntradas();
            mostrarDatos();
        } else {
            pantallaAuto.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
        pantallaAuto.setAlwaysOnTop(true);
    }

    public void eliminarAuto() {
        Auto autoObject = pantallaAuto.getAuto();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta auto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(autoObject);
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
        modelo.addColumn("Precio Costo");

        Object data[] = new Object[8];
        try {
            for (Auto auto : listaAutos) {
                data[0] = auto;
                data[1] = auto.getMarca().getNombre();
                data[2] = auto.getModelo().getNombre();
                data[3] = Integer.toString(auto.getAñoFabricacion());
                data[4] = auto.getCombustible().getNombre();
                data[5] = auto.getColor();
                data[6] = Double.toString(auto.getPrecio());
                data[7] = Double.toString(auto.getPrecioCosto());

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
                listaModelos = gestorModelo.conocerModelosDeMarca(pantallaAuto.getMarca());
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
        gestorMarca.suscribirGestorAuto(this);
        solicitarActualizacion();
    }

    void mostrarModeloABMC() {
        gestorModelo.mostrarPantalla(true);
        gestorModelo.suscribirGestor(this);
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

    int conocerUltimoIdAuto() {
        conocerAutos();
        if (listaAutos.isEmpty()) {
            ultimoIdAuto = 0;
        } else {
            Optional<Integer> maximoId = listaAutos.stream()
                    .map(Auto::getId)
                    .max(Integer::compare);

            ultimoIdAuto = maximoId.get();
        }

        return ultimoIdAuto + 1;
    }
    
    public boolean validarCamposVacios(JTextField txtAñoFabricacion, JTextField txtPrecio, JTextField txtPrecioCosto) {
        if(txtAñoFabricacion.getForeground().equals(disableColor) || txtPrecio.getForeground().equals(disableColor) || txtPrecioCosto.getForeground().equals(disableColor)) {
            return false;
        }else {
            return (validarCampoNumerico(txtAñoFabricacion.getText()) && 
                    validarCampoNumerico(txtPrecio.getText()) && 
                    validarCampoNumerico(txtPrecioCosto.getText())
                    );
        }
    }
    
    public boolean validarCampoNumerico(String campoNumerico) {
        for (int i = 0; i < campoNumerico.length(); i++)
        {
            char c = campoNumerico.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        if(campoNumerico.isBlank()) {
            return false;
        }
        return true;
    }
}
