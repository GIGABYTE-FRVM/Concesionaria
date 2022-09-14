package main.java.net.javaguides.concesionaria;




import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.MarcaDao;
import net.javaguides.hibernate.model.Marca;

public class GestorMarcaABMC {

    //ArrayList<Pais> listaPaises;
    private List<Marca> listaMarcas;
    //GestorPaisABMC gestorPais = new GestorPaisABMC();
    MarcaABMC marca;
    MarcaDao marcaDao = new MarcaDao();

    public GestorMarcaABMC() {
        marca = new MarcaABMC(this);
        marca.setVisible(true);
    }

    /*
    public void conocerPaises(){
        if (!(listaPaises==null)){
            listaPaises.clear();
        }
        listaPaises = gestorPais.conocerPaises();
    }*/
    public void modificarMarca() {
        Marca marcaObject = marcaDao.getMarcaById(Integer.parseInt(marca.getTxtId()));
        marcaObject.setNombre(marca.getTxtNombre());
        marcaObject.setCodigo(marca.getTxtCodigo());
        marcaObject.setDescripcion(marca.getTxtDescripcion());
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            marcaDao.updateMarca(marcaObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }
    public void conocerMarcas() {
        listaMarcas = marcaDao.getAllMarcas();
    }
        
    
    public DefaultTableModel mostrarDatos() {
        this.conocerMarcas();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        String data[] = new String[4];
        try {
            for (Marca marca : listaMarcas) {
                data[0] = Integer.toString((int) marca.getId());
                data[1] = marca.getCodigo();
                data[2] = marca.getNombre();
                data[3] = marca.getDescripcion();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void registrarMarca() {
        String codigo = marca.getTxtCodigo();
        String nombre = marca.getTxtNombre();
        String descripcion = marca.getTxtDescripcion();
        Marca marcaObject = new Marca(codigo, nombre, descripcion);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if ((codigo.length() != 0) && (nombre.length() != 0) && (descripcion.length() != 0)) {
            marcaDao.saveMarca(marcaObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }

    }

    public void eliminarMarca() {
        String id = marca.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta marca?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            marcaDao.deleteMarca(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    void mostrarPaisABMC() {
        //gestorPais.mostrarPantalla();
    }

}
