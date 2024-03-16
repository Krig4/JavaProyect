package paqueteaccesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccesoDatos {
   
    private static String url_mysql = "jdbc:mysql://localhost:3306/bd_alumnos?user=root";    
    public static void insertarContacto(Contacto c) 
    {
         try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url_mysql); 
            Statement stmt = conn.createStatement();
            String sql ="INSERT INTO t_alumnos (nombre, edad, telefono) VALUES('" + c.getNombre() + "','" + c.getEdad() + "','" + c.getTelefono() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    public static ArrayList<Contacto> recuperarContactos() {
        ArrayList<Contacto> lista = new ArrayList<>();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url_mysql); 
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM t_alumnos";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String nombre = rs.getString("nombre");
            	String edad = rs.getString("edad");
            	String telefono = rs.getString("telefono");
            	Contacto c = new Contacto(nombre, edad, telefono);
            	lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return lista;
    }
    
    public static ArrayList<Contacto> buscarContactos(String nombre) {
    	ArrayList<Contacto> lista = new ArrayList<>();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url_mysql); 
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM t_alumnos WHERE nombre= '" + nombre + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	String nombreAlumno = rs.getString("nombre");
            	String edad = rs.getString("edad");
            	String telefono = rs.getString("telefono");
            	Contacto c = new Contacto(nombreAlumno, edad, telefono);
            	lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return lista;
    }
    
    public static void borrarContacto(String tlf) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url_mysql); 
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM t_alumnos WHERE telefono = '" + tlf + "'";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

