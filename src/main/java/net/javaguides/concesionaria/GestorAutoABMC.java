package net.javaguides.concesionaria;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.AutoDao;
import net.javaguides.hibernate.dao.CombustibleDao;
import net.javaguides.hibernate.dao.MarcaDao;
import net.javaguides.hibernate.dao.ModeloDao;
import net.javaguides.hibernate.dao.PaisDao;
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
    MarcaDao marcaDao = new MarcaDao();
    ModeloDao modeloDao = new ModeloDao();
    CombustibleDao combustibleDao = new CombustibleDao();
    AutoDao autoDao = new AutoDao();

    public GestorAutoABMC() {
        gestorCombustible = new GestorCombustibleABMC();
        gestorModelo = new GestorModeloABMC();
        gestorMarca = new GestorMarcaABMC();
        gestorMarca.mostrarPantalla(false);
        gestorModelo.mostrarPantalla(false);
        gestorCombustible.mostrarPantalla(false);
        pantallaAuto = new AutoABMC(this);
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
        try{
            if(!(pantallaAuto==null)){
                listaModelos = gestorModelo.conocerModelosDeMarca(listaMarcas.get(pantallaAuto.getMarca()));
            }else{
                listaModelos = gestorModelo.conocerListaModelos();
            }
        
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Agarre la exe");
        }
    }

    public void conocerCombustibles() {
        if (!(listaCombustibles == null)) {
            listaCombustibles.clear();
        }
        listaCombustibles = gestorCombustible.conocerListaCombustibles();
    }

    public void modificarAuto() {
        Auto autoObject = autoDao.getAutoById(Integer.parseInt(pantallaAuto.getTxtId()));
        autoObject.setPrecio(Double.parseDouble(pantallaAuto.getTxtPrecio()));
        autoObject.setAñoFabricacion(Integer.parseInt(pantallaAuto.getTxtAñoFabricacion()));
        autoObject.setModelo(listaModelos.get(pantallaAuto.getModelo()));
        autoObject.setMarca(listaMarcas.get(pantallaAuto.getMarca()));
        autoObject.setCombustible(listaCombustibles.get(pantallaAuto.getCombustible()));
        autoObject.setColor(pantallaAuto.getColor());

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
        autoObject.setColor(pantallaAuto.getColor());
        if ((pantallaAuto.getTxtPrecio().length() != 0) && (pantallaAuto.getTxtAñoFabricacion().length() != 0)) {
            autoDao.saveAuto(autoObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }

    }

    public void eliminarAuto() {
        String id = pantallaAuto.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta auto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
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
        gestorModelo.mostrarPantalla(true);
    }

    void mostrarCombustibleABMC() {
        gestorCombustible.mostrarPantalla(true);
    }

    public void mostrarPantalla(boolean visible) {
        pantallaAuto.setVisible(visible);
    }
}
