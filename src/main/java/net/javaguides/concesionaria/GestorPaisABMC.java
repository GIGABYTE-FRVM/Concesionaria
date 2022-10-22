package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Pais;
import net.javaguides.hibernate.model.Region;

public class GestorPaisABMC {
    
    List<Region> listaRegiones;
    private List<Pais> listaPaises;
    GestorRegionABMC gestorRegion = new GestorRegionABMC(this);
    GestorHibernate gestorHibernate;
    GestorMarcaABMC gestorMarca;
    Notificador notificador;

    PaisABMC pantallaPais;

    public GestorPaisABMC(GestorMarcaABMC gestorMarca) {
        gestorHibernate = new GestorHibernate();
        pantallaPais = new PaisABMC(this);
    }

    public void registrarPais() {
        String nombre = pantallaPais.getTxtNombre();
        Region region = pantallaPais.getRegion();
        Pais paisObject = new Pais(nombre, region);
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
        paisObject.setRegion(pantallaPais.getRegion());
        if (esValido(paisObject,1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(paisObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    }
    
    public void conocerPaises(){
        listaPaises = gestorHibernate.getAllObjects("Pais");
    }
    
    public void conocerRegiones() {
        if (!(listaRegiones == null)){
            listaRegiones.clear();
        }
        listaRegiones = gestorRegion.conocerListRegiones();
    }


    public DefaultTableModel mostrarDatos() {
        this.conocerPaises();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Region");
        Object data[] = new Object[3];
        try {for(Pais pais : listaPaises){
                data[0] = Integer.toString(pais.getId());
                data[1] = pais.getNombre();
                data[2] = pais.getRegion().getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarPais(){
        Pais paisObject = pantallaPais.getPais();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este pais?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(paisObject);
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    
    void mostrarRegionesABMC() {
        gestorRegion.mostrarPantalla();
        gestorRegion.notificarGestor(this);
        solicitarActualizacionRegiones();
    }
    
    void actualizarComboRegiones(){
        pantallaPais.actualizarComboRegiones();
    }
    
     synchronized void solicitarActualizacionRegiones() {
        notificador = new Notificador();
        new Thread(() -> {
            notificador.solicitar();
        }).start();
    }
    
  
    
    public void notificarGestor(GestorMarcaABMC gestorSubscrito){
        this.gestorMarca = gestorSubscrito;
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

    void notificarActualizacionRegiones() {
       new Thread(() -> {
            notificador.entregar();
            conocerPaises();
            pantallaPais.actualizarComboRegiones();
        }).start();
    }

    void mostrarPaisABMC() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
