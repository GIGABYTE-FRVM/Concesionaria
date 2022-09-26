package net.javaguides.concesionaria;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.javaguides.hibernate.dao.ClienteDao;
import net.javaguides.hibernate.model.Cliente;

public class GestorClienteABMC {

    private List<Cliente> listaClientes;
    ClienteABMC pantallaCliente;
    ClienteDao clienteDao = new ClienteDao();

    
    public GestorClienteABMC() {
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
        //ps.setString(4, cboPais.getSelectedItem().toString());
        if ((nombre.length() != 0) && (apellido.length() != 0) && (direccion.length() != 0) && (documento.length() != 0)
                && (email.length() != 0) && (telefono.length() != 0) && (fechaNacimiento.length() != 0)) {
            clienteDao.saveCliente(clienteObject);
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
        }
    }
    
    public void modificarCliente() {
        Cliente clienteObject;
        clienteObject = clienteDao.getClienteById(Integer.parseInt(pantallaCliente.getTxtId()));
        clienteObject.setNombre(pantallaCliente.getTxtNombre());
        clienteObject.setApellido(pantallaCliente.getTxtApellido());
        clienteObject.setDireccion(pantallaCliente.getTxtDireccion());
        clienteObject.setDocumento(pantallaCliente.getTxtDNI());
        clienteObject.setEmail(pantallaCliente.getTxtEmail());
        clienteObject.setTelefono(pantallaCliente.getTxtTelefono());
        clienteObject.setFechaNacimiento(pantallaCliente.getTxtFechaNacimiento());
        System.out.println(clienteObject);
        
        if (true) {
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
            clienteDao.updateCliente(clienteObject);
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
        } 
    };
    
    public void conocerClientes(){
        listaClientes = clienteDao.getAllCliente();
    }
    
    public List<Cliente> conocerListclientes(){
        conocerClientes();
        return listaClientes;
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
        String data[] = new String[9];
        try {for(Cliente cliente : listaClientes){
                data[0] = Integer.toString(cliente.getId());
                data[1] = cliente.getNombre();
                data[2] = cliente.getApellido();
                data[3] = cliente.getDireccion();
                data[4] = cliente.getDocumento();
                data[5] = cliente.getEmail();
                data[6] = cliente.getTelefono();
                data[7] = cliente.getFechaNacimiento();
                data[8] = Boolean.toString(cliente.isEsCliente());

                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarCliente(){
        String id = pantallaCliente.getTxtId();
        int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (pantallaConfirmarEliminacion == 0) {
            clienteDao.deleteCliente(Integer.parseInt(id));
            // si selecciona SI (primer boton) ejecuta la eliminacion
        } else {
            //No hace nada
        }
    }
    
    public void mostrarPantalla() {
        pantallaCliente.setVisible(true);
    }
}
