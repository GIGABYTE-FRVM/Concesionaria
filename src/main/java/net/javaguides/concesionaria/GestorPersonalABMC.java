package net.javaguides.concesionaria;

import java.awt.Color;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.GestorHibernate;
import net.javaguides.hibernate.model.Marca;
import net.javaguides.hibernate.model.Personal;

public class GestorPersonalABMC {

    private List<Personal> listaPersonales;
    
    private int ultimoIdPersonal;

    GestorHibernate gestorHibernate;

    PersonalABMC pantallaPersonal;
    
    Color disableColor = new Color(153,153,153);

    public GestorPersonalABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
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
        System.out.println(personalObject);
        if (esValido(personalObject, 0)) {
            gestorHibernate.saveObject(personalObject);
            pantallaPersonal.limpiarEntradas();
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR LOS DATOS. REVISE SU ENTRADA");
        }
    }

    public void modificarPersonal() {
        Personal personalObject = (Personal) pantallaPersonal.getPersonal();
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
        if (esValido(personalObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(personalObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarPersonal() {
        Personal personalObject = (Personal)pantallaPersonal.getPersonal();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este personal?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(personalObject);
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
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
        Object data[] = new Object[11];
        try {
            for (Personal personal : listaPersonales) {
                data[0] = personal.getId();
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

    public void conocerPersonales() {
        listaPersonales = gestorHibernate.getAllObjects("Personal");
    }

    public List<Personal> conocerListaPersonales() {
        conocerPersonales();
        return listaPersonales;
    }

    public void mostrarPantalla() {
        pantallaPersonal.setVisible(true);
    }

    public boolean esValido(Personal personal, int tipo) {
        if (personal.getNombre().length() == 0 || personal.getApellido().length() == 0 || personal.getDireccion().length() == 0
                || personal.getDocumento().length() == 0 || personal.getEmail().length() == 0 || personal.getFechaNacimiento().length() == 0
                || personal.getFechaIngresoEmpresa().length() == 0 || personal.getHoraEntrada().length() == 0 || personal.getHoraSalida().length() == 0) {
            return false;
        }  
        if (tipo == 0) {
            for (Personal personalOfList : listaPersonales) {
                if (personalOfList.getDocumento().equalsIgnoreCase(personal.getDocumento())) {
                    return false;
                }
            }
        }
        return true;
    }

    List<Personal> conocerListVendedores() {
        conocerPersonales();
        return listaPersonales;
    }

    public int conocerUltimoIdPersonal() {
        conocerPersonales();
        if (listaPersonales.isEmpty()) {
            ultimoIdPersonal = 0;
        } else {
            Optional<Integer> maximoId = listaPersonales.stream()
                    .map(Personal::getId)
                    .max(Integer::compare);

            ultimoIdPersonal = maximoId.get();
        }

        return ultimoIdPersonal + 1;
    }
    
    public boolean validarCamposVacios(JTextField txtNombre, JTextField txtApellido, JTextField txtDireccion, JTextField txtDNI, JTextField txtEmail, JTextField txtTelefono, 
            JTextField txtFechaNacimiento, JTextField txtFechaIngresoEmpresa, JTextField txtHoraEntrada, JTextField txtHoraSalida) {
        if(txtNombre.getForeground().equals(disableColor) || txtApellido.getForeground().equals(disableColor) || txtDireccion.getForeground().equals(disableColor)
                || txtDNI.getForeground().equals(disableColor) || txtEmail.getForeground().equals(disableColor) || txtTelefono.getForeground().equals(disableColor)
                || txtFechaNacimiento.getForeground().equals(disableColor) || txtFechaIngresoEmpresa.getForeground().equals(disableColor) || txtHoraEntrada.getForeground().equals(disableColor)
                || txtHoraSalida.getForeground().equals(disableColor)) {
            return false;
        }else {
            return (validarCamposNumericos(txtDNI.getText()) && 
                    validarCamposNumericos(txtTelefono.getText()) &&
                    validarCamposTexto(txtNombre.getText()) && 
                    validarCamposTexto(txtApellido.getText()) &&
                    validarEmail(txtEmail.getText()));
        }
    }
    
    public boolean validarCamposNumericos(String campoNumerico) {
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
    
    public boolean validarCamposTexto(String campoTexto) {
        campoTexto = campoTexto.toUpperCase();
        return campoTexto.matches("[A-Z]*");
    }
    
    public boolean validarEmail(String email) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
}
