package concesionaria;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorPaisABMC {

    ConexionMySQL con = new ConexionMySQL();
    Connection cn = con.conectar();
    private ArrayList<Pais> listaPaises = new ArrayList<Pais>();
    PaisABMC pantallaPais;
    
    public GestorPaisABMC() {
        pantallaPais = new PaisABMC(this);
    }
    
    public void registrarPais(String nombre) {
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO Pais (nombre) VALUES (?)");
            ps.setString(1,nombre);
            
            if((nombre.length()!=0)){
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            }else{
                JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS");
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL REGISTRAR PAIS" + e);
        }
    }
    
    public void modificarPais(String nombre, String id) {
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE Pais SET nombre='" + nombre + "' WHERE id='" + id + "'");
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
    public ArrayList<Pais> conocerPaises(){
        conocerPais();
        return listaPaises;
    }
    public void conocerPais(){
        String consultasql = "SELECT * FROM Pais";
        Statement st;
        listaPaises.clear();
        try {
            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(consultasql);
            int id;
            String nombre;
            while (rs.next()) {
                id = Integer.valueOf(rs.getString(1));
                nombre = rs.getString(2);
                Pais pais = new Pais(id,nombre);
                listaPaises.add(pais);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos " + e);
        }
    }
    public DefaultTableModel mostrarDatos() {
        this.conocerPais();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        String data[] = new String[2];
        try {for(Pais pais : listaPaises){
                data[0] = Integer.toString(pais.getId());
                data[1] = pais.getNombre();
                modelo.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar datos" + e);
        }
        return modelo;
    }
    
    public void eliminarPais(String id){
    try{
            PreparedStatement ps = cn.prepareStatement("DELETE FROM Pais WHERE id='"+id+"'");
            int pantallaConfirmarEliminacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este pais?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pantallaConfirmarEliminacion == 0) {
                ps.executeUpdate(); // si selecciona SI (primer boton) ejecuta la eliminacion
            } else {
                //No hace nada
            }

        }catch (SQLException e){
            System.out.println("ERROR:"+e);}
    }
    
    public void mostrarPantalla() {
        pantallaPais.setVisible(true);
    }
}
