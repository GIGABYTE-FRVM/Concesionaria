package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.PersonalDao;
import net.javaguides.hibernate.model.Personal;

public class GestorPersonalABMC {

    private List<Personal> listaPersonales;
    PersonalABMC pantallaPersonal;
    PersonalDao personalDao = new PersonalDao();

    
    public GestorPersonalABMC() {
        pantallaPersonal = new PersonalABMC(this);
    }
    
    public void registrarPersonal() {
        String nombre = pantallaPersonal.getTxtNombre();
        String apellido = pantallaPersonal.getTxtApellido();
        String direccion = pantallaPersonal.getTxtDireccion();
        String documento = pantallaPersonal.getTxtDNI();
        String email = pantallaPersonal.getTxtEmail();
        String telefono = pantallaPersonal.getTxtTelefono();
        String fechaNacimiento = pantallaPersonal.getTxtFechaNacimiento();
        
        Personal personalObject = new Personal(nombre, apellido, direccion, documento, email, telefono, fechaNacimiento);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if ((nombre.length() != 0) && (apellido.length() != 0) && (direccion.length() != 0) && (documento.length() != 0)
                && (email.length() != 0) && (telefono.length() != 0) && (fechaNacimiento.length() != 0)) {
            personalDao.savePersonal(personalObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarPersonal() {
        Personal personalObject;
        personalObject = personalDao.getPersonalById(Integer.parseInt(pantallaPersonal.getTxtId()));
        personalObject.setNombre(pantallaPersonal.getTxtNombre());
        personalObject.setApellido(pantallaPersonal.getTxtApellido());
        personalObject.setDireccion(pantallaPersonal.getTxtDireccion());
        personalObject.setDocumento(pantallaPersonal.getTxtDNI());
        personalObject.setEmail(pantallaPersonal.getTxtEmail());
        personalObject.setTelefono(pantallaPersonal.getTxtTelefono());
        personalObject.setFechaNacimiento(pantallaPersonal.getTxtFechaNacimiento());
        System.out.println(personalObject);
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            personalDao.updatePersonal(personalObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    
    public void conocerPersonales(){
        listaPersonales = personalDao.getAllpersonal();
    }
    
    public List<Personal> conocerListpersonales(){
        conocerPersonales();
        return listaPersonales;
    }
    
    public DefaultTableModel mostrarDatos() {
        this.conocerPersonales();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Documento");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("FechaNacimiento");
        String data[] = new String[8];
        try {for(Personal personal : listaPersonales){
                data[0] = Integer.toString(personal.getId());
                data[1] = personal.getNombre();
                data[2] = personal.getApellido();
                data[3] = personal.getDireccion();
                data[4] = personal.getDocumento();
                data[5] = personal.getEmail();
                data[6] = personal.getTelefono();
                data[7] = personal.getFechaNacimiento();

                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarPersonal(){
        String id = pantallaPersonal.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este personal?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            personalDao.deletePersonal(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    
    public void mostrarPantalla() {
        pantallaPersonal.setVisible(true);
    }
}
