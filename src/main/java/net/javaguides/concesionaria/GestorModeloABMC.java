package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.ModeloDao;
import net.javaguides.hibernate.model.Modelo;

public class GestorModeloABMC {

    private List<Modelo> listaModelos;
    ModeloABMC pantallaModelo;
    ModeloDao modeloDao = new ModeloDao();

    
    public GestorModeloABMC() {
        pantallaModelo = new ModeloABMC(this);
    }
    
    public void registrarModelo() {
        String nombre = pantallaModelo.getTxtNombre();
        String version = pantallaModelo.getTxtVersion();
        String añoLanzamiento = pantallaModelo.getTxtAñoLanzamiento();
        Modelo modeloObject = new Modelo(nombre, version, añoLanzamiento);
        //ps.setString(4, cboModelo.getSelectedItem().toString());
       if ((nombre.length() != 0) && (version.length() != 0) && (añoLanzamiento.length() != 0)) {
            modeloDao.saveModelo(modeloObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarModelo() {
        Modelo modeloObject;
        modeloObject = modeloDao.getModeloById(Integer.parseInt(pantallaModelo.getTxtId()));
        modeloObject.setNombre(pantallaModelo.getTxtNombre());
        modeloObject.setVersion(pantallaModelo.getTxtVersion());
        modeloObject.setAñoLanzamiento(pantallaModelo.getTxtAñoLanzamiento());
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            modeloDao.updateModelo(modeloObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    
    public void conocerModelos(){
        listaModelos = modeloDao.getAllModelos();
    }
    public List<Modelo> conocerListModelos(){
        conocerModelos();
        return listaModelos;
    }
    public DefaultTableModel mostrarDatos() {
        this.conocerModelos();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Version");
        modelo.addColumn("AñoLanzamiento");
        String data[] = new String[4];
        try {
            for (Modelo modeloObject : listaModelos) {
                data[0] = Integer.toString((int) modeloObject.getId());
                data[1] = modeloObject.getNombre();
                data[2] = modeloObject.getVersion();
                data[3] = modeloObject.getAñoLanzamiento();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarModelo(){
        String id = pantallaModelo.getTxtId();
        String nombre = pantallaModelo.getTxtNombre();
        String version = pantallaModelo.getTxtVersion();
        String añoLanzamiento = pantallaModelo.getTxtAñoLanzamiento();
        
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este modelo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            modeloDao.deleteModelo(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    
    public void mostrarPantalla() {
        pantallaModelo.setVisible(true);
    }
}
