package concesionaria;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorMarcaABMC {

    ConexionMySQL con = new ConexionMySQL();
    Connection cn = con.conectar();
    private ArrayList<Marca> listaMarcas = new ArrayList<Marca>();
    public GestorMarcaABMC() {
    }
    
    public void modificarMarca(String codigo, String nombre, String descripcion, String id) {
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE Marca SET codigo='" + codigo + "',nombre='" + nombre + "',descripcion='" + descripcion + "' WHERE id='" + id + "'");
            int indice = ps.executeUpdate();
            if (indice > 0) {
                JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE");
                mostrarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR DATOS");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    };

    public void conocerMarcas(){
        String consultasql = "SELECT * FROM Marca";
        Statement st;
        listaMarcas.clear();
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultasql);
            int id;
            String codigo;
            String nombre;
            String descripcion;
            while (rs.next()) {
                id = Integer.valueOf(rs.getString(1));
                codigo = rs.getString(2);
                nombre = rs.getString(3);
                descripcion = rs.getString(4);
                Marca marca = new Marca(id,codigo,nombre,descripcion);
                listaMarcas.add(marca);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos" + e);
        }
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
            for(Marca marca : listaMarcas){
                data[0] = Integer.toString(marca.getId());
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
    public void registrarMarca(String codigo, String nombre, String descripcion) {
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Marca (codigo,nombre,descripcion) VALUES (?,?,?)");
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, descripcion);
            //ps.setString(4, cboPais.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");

        } catch (SQLException e) {
            System.out.println("ERROR AL REGISTRAR CLIENTE" + e);
        }
    }
    public void eliminarMarca(String id){
    try{
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Marca WHERE id='"+id+"'");
            JOptionPane.showConfirmDialog(null, ps);
            ps.executeUpdate();
            
        }catch (SQLException e){
            System.out.println("ERROR:"+e);}
    }
}
