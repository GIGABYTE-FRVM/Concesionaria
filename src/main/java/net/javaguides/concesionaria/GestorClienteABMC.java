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
import net.javaguides.hibernate.model.Cliente;
import net.javaguides.hibernate.model.Marca;

public class GestorClienteABMC {

    private List<Cliente> listaClientes;
    
    private int ultimoIdCliente;

    Color disableColor = new Color(153,153,153);
    
    GestorHibernate gestorHibernate;

    ClienteABMC pantallaCliente;

    public GestorClienteABMC() {
        gestorHibernate = GestorHibernate.getInstancia();
        pantallaCliente = new ClienteABMC(this);
    }

    public void registrarCliente() {
        String nombre = pantallaCliente.getTxtNombre();
        String apellido = pantallaCliente.getTxtApellido();
        String direccion = pantallaCliente.getTxtDireccion();
        String documento = pantallaCliente.getTxtDNI();
        String email = pantallaCliente.getTxtEmail();
        String telefono = pantallaCliente.getTxtTelefono();
        String fechaNacimiento = pantallaCliente.getTxtFechaNacimiento();
        Cliente clienteObject = new Cliente(nombre, apellido, direccion, documento, email, telefono, fechaNacimiento);
        if (esValido(clienteObject, 0)) {
            gestorHibernate.saveObject(clienteObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            pantallaCliente.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }

    public void modificarCliente() {
        Cliente clienteObject;
        clienteObject = (Cliente)pantallaCliente.getCliente();
        clienteObject.setNombre(pantallaCliente.getTxtNombre());
        clienteObject.setApellido(pantallaCliente.getTxtApellido());
        clienteObject.setDireccion(pantallaCliente.getTxtDireccion());
        clienteObject.setDocumento(pantallaCliente.getTxtDNI());
        clienteObject.setEmail(pantallaCliente.getTxtEmail());
        clienteObject.setTelefono(pantallaCliente.getTxtTelefono());
        clienteObject.setFechaNacimiento(pantallaCliente.getTxtFechaNacimiento());
        if (esValido(clienteObject, 1)) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            gestorHibernate.updateObject(clienteObject);
            mostrarDatos();
            pantallaCliente.limpiarEntradas();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        }
    }

    public void eliminarCliente() {
        Cliente clienteObject = (Cliente)pantallaCliente.getCliente();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            gestorHibernate.deleteObject(clienteObject);
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }

    public DefaultTableModel mostrarDatos() {
        this.conocerClientes();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Documento");
        modelo.addColumn("Email");
        modelo.addColumn("Telefono");
        modelo.addColumn("FechaNacimiento");
        modelo.addColumn("esCliente");
        Object data[] = new Object[9];
        try {
            for (Cliente cliente : listaClientes) {
                data[0] = cliente.getId();
                data[1] = cliente;
                data[2] = cliente.getApellido();
                data[3] = cliente.getDireccion();
                data[4] = cliente.getDocumento();
                data[5] = cliente.getEmail();
                data[6] = cliente.getTelefono();
                data[7] = cliente.getFechaNacimiento();
                data[8] = cliente.getEsCliente()==0?"No":"Si";
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }

    public void conocerClientes() {
        listaClientes = gestorHibernate.getAllObjects("Cliente");
    }

    public List<Cliente> conocerListclientes() {
        conocerClientes();
        return listaClientes;
    }

    public boolean esValido(Cliente cliente, int tipo) {

        if (cliente.getNombre().length() == 0 || cliente.getApellido().length() == 0 || cliente.getDireccion().length() == 0
                || cliente.getDocumento().length() == 0 || cliente.getEmail().length() == 0 || cliente.getFechaNacimiento().length() == 0) {
            return false;
        }
        if (tipo == 0) {
            for (Cliente clienteOfList : listaClientes) {
                if (clienteOfList.getDocumento().equalsIgnoreCase(cliente.getDocumento())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarPantalla() {
        pantallaCliente.setVisible(true);
    }

    public int conocerUltimoIdCliente() {
        conocerClientes();
        if (listaClientes.isEmpty()) {
            ultimoIdCliente = 0;
        } else {
            Optional<Integer> maximoId = listaClientes.stream()
                    .map(Cliente::getId)
                    .max(Integer::compare);

            ultimoIdCliente = maximoId.get();
        }

        return ultimoIdCliente + 1;
    }
    
    public boolean validarCamposVacios(JTextField txtNombre, JTextField txtApellido, JTextField txtDireccion, JTextField txtDNI, JTextField txtEmail, JTextField txtTelefono, JTextField txtFechaNacimiento) {
        if(txtNombre.getForeground().equals(disableColor) || txtApellido.getForeground().equals(disableColor) || txtDireccion.getForeground().equals(disableColor)
                || txtDNI.getForeground().equals(disableColor) || txtEmail.getForeground().equals(disableColor) || txtTelefono.getForeground().equals(disableColor)
                || txtFechaNacimiento.getForeground().equals(disableColor)) {
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