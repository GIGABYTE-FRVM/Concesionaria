package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Personal;

public class GestorPersonalABMC {

    private List<Personal> listaPersonales;
    PersonalABMC pantallaPersonal;
    GestorHibernate gestorHibernate = new GestorHibernate();

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
        String fechaIngresoEmpresa = pantallaPersonal.getTxtFechaIngresoEmpresa();
        String horaEntrada = pantallaPersonal.getTxtHoraEntrada();
        String horaSalida = pantallaPersonal.getTxtHoraSalida();

        Personal personalObject = new Personal(nombre, apellido, direccion, documento, email, telefono, fechaNacimiento, fechaIngresoEmpresa, horaEntrada, horaSalida);
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if (esValido(personalObject,0)) {
            gestorHibernate.saveObject(personalObject);
            pantallaPersonal.limpiarEntradas();
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS. REVISE SU ENTRADA");
        }
    }

    public void modificarPersonal() {
        Personal personalObject;
        personalObject = gestorHibernate.getObjectById("Personal",Integer.parseInt(pantallaPersonal.getTxtId()));
        personalObject.setNombre(pantallaPersonal.getTxtNombre());
        personalObject.setApellido(pantallaPersonal.getTxtApellido());
        personalObject.setDireccion(pantallaPersonal.getTxtDireccion());
        personalObject.setDocumento(pantallaPersonal.getTxtDNI());
        personalObject.setEmail(pantallaPersonal.getTxtEmail());
        personalObject.setTelefono(pantallaPersonal.getTxtTelefono());
        personalObject.setFechaNacimiento(pantallaPersonal.getTxtFechaNacimiento());
        personalObject.setFechaIngresoEmpresa(pantallaPersonal.getTxtFechaIngresoEmpresa());
        personalObject.setHoraEntrada(pantallaPersonal.getTxtHoraEntrada());
        personalObject.setHoraSalida(pantallaPersonal.getTxtHoraSalida());
        System.out.println(personalObject);

        if (esValido(personalObject,1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(personalObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    ;
    
    public void conocerPersonales() {
        listaPersonales = gestorHibernate.getAllObjects("Personal");
    }

    public List<Personal> conocerListpersonales() {
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
        modelo.addColumn("Fecha Ingreso Empresa");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Hora Salida");

        String data[] = new String[11];
        try {
            for (Personal personal : listaPersonales) {
                data[0] = Integer.toString(personal.getId());
                data[1] = personal.getNombre();
                data[2] = personal.getApellido();
                data[3] = personal.getDireccion();
                data[4] = personal.getDocumento();
                data[5] = personal.getEmail();
                data[6] = personal.getTelefono();
                data[7] = personal.getFechaNacimiento();
                data[8] = personal.getFechaIngresoEmpresa();
                data[9] = personal.getHoraEntrada();
                data[10] = personal.getHoraSalida();

                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void eliminarPersonal() {
        String id = pantallaPersonal.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este personal?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject("Personal",Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public void mostrarPantalla() {
        pantallaPersonal.setVisible(true);
    }
    
    public boolean esValido(Personal personal,int tipo){
        if(personal.getNombre().length() == 0 || personal.getApellido().length() == 0 || personal.getDireccion().length() == 0 ||
                personal.getDocumento().length() == 0 || personal.getEmail().length() == 0 || personal.getFechaNacimiento().length() == 0 ||
                personal.getFechaIngresoEmpresa().length() == 0 || personal.getHoraEntrada().length() == 0 ||personal.getHoraSalida().length() == 0 ){
            return false;
        }
        if(tipo==0){
        for(Personal personalOfList : listaPersonales){
            if(personalOfList.getDocumento().equalsIgnoreCase(personal.getDocumento())){
                return false;
            }
        }
        }
        return true;
    }
}
