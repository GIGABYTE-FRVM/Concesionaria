package concesionaria;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class ConexionMySQL {
    Connection cn;
    
    public Connection conectar(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/concesionaria","root","");
            System.out.println("CONECTADO");
    }catch (Exception e){
        System.out.println("ERROR:"+e);
    }
    return cn;
    }
}
