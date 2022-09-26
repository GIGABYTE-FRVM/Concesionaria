package net.javaguides.concesionaria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.AutoDao;
import net.javaguides.hibernate.dao.CombustibleDao;
import net.javaguides.hibernate.dao.MarcaDao;
import net.javaguides.hibernate.dao.PaisDao;
import net.javaguides.hibernate.model.Auto;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Modelo;
import net.javaguides.hibernate.model.Combustible;
import net.javaguides.hibernate.model.Color;

public class GestorAutoABMC {

    List<Marca> listaMarcas;
    List<Modelo> listaModelos;
    List<Combustible> listaCombustibles;
    List<Color> listaColores;
    List<Auto> listaAutos;


    GestorMarcaABMC gestorMarca = new GestorMarcaABMC();
    GestorModeloABMC gestorModelo = new GestorModeloABMC();
    GestorCombustibleABMC gestorCombustible = new GestorCombustibleABMC();
    GestorColorABMC gestorColor = new GestorColorABMC();

    AutoABMC pantallaAuto;
    MarcaDao marcaDao = new MarcaDao();
    ModeloDao modeloDao = new ModeloDao();
    CombustibleDao combustibleDao = new CombustibleDao();
    ColorDao colorDao = new ColorDao();
    AutoDao autoDao = new AutoDao();

    public GestorAutoABMC() {
        pantallaAuto = new AutoABMC(this);
        pantallaAuto.setVisible(true);
    }

    public void conocerMarcas() {
        if (!(listaMarcas == null)) {
            listaMarcas.clear();
        }
        listaMarcas = gestorMarca.conocerListaMarcas();
    }

    public void conocerModelo() {
        if (!(listaModelos == null)) {
            listaModelos.clear();
        }
        listaModelos = gestorModelo.conocerListaModelos();
    }

    public void conocerCombustibles() {
        if (!(listaCombustibles == null)) {
            listaCombustibles.clear();
        }
        listaCombustibles = gestorCombustible.conocerListaCombustibles();
    }

    public void conocerColores() {
        if (!(listaColores == null)) {
            listaColores.clear();
        }
        listaColores = gestorColor.conocerListaColores();
    }

    public void modificarAuto() {
        Auto autoObject = autoDao.getMarcaById(Integer.parseInt(pantallaAuto.getTxtId()));
        autoObject.setPrecio(Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setModelo(listaModelos.get(pantallaAuto.getModelo()));
        autoObject.setMarca(listaMarcas.get(pantallaAuto.getMarca()));
        autoObject.setCombustible(listaCombustibles.get(pantallaAuto.getCombustible()));
        autoObject.setColor(listaColores.get(pantallaAuto.getColor()));

        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            autoDao.updateAuto(autoObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void conocerAutos() {
        listaAutos = autoDao.getAllAuto();
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerMarcas();
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
            for (Marca marca : listaMarcas) {
                data[0] = Integer.toString((int) marca.getId());
                data[1] = marca.getCodigo();
                data[2] = marca.getNombre();
                data[3] = marca.getDescripcion();
                data[4] = marca.getPais().getNombre();
                data[5] = marca.getDescripcion();
                data[6] = marca.getDescripcion();
                data[7] = marca.getDescripcion();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void registrarAuto() {
        Auto autoObject = new Auto();
        autoObject.setPrecio(Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setModelo(listaModelos.get(pantallaAuto.getModelo()));
        autoObject.setMarca(listaMarcas.get(pantallaAuto.getMarca()));
        autoObject.setCombustible(listaCombustibles.get(pantallaAuto.getCombustible()));
        autoObject.setColor(listaColores.get(pantallaAuto.getColor()));
        if ((pantallaAuto.getTxtPrecio().length() != 0) && (pantallaAuto.getTxtAñoFabricacion().length() != 0)) {
            autoDao.saveAuto(autoObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }

    }

    public void eliminarAuto() {
        String id = pantallaAuto.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta marca?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            autoDao.deleteAuto(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    void mostrarMarcaABMC() {
        gestorMarca.mostrarPantalla(true);
    }
    void mostrarModeloABMC() {
        gestorModelo.mostrarPantalla();
    }
    void mostrarCombustibleABMC() {
        gestorCombustible.mostrarPantalla();
    }
    void mostrarColorABMC() {
        gestorColor.mostrarPantalla();
    }

    void actualizarComboPaises() {
        pantallaAuto.actualizarCombos();
    }

    public void mostrarPantalla(boolean visible) {
        pantallaAuto.setVisible(visible);
    }

    void conocerModelos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
