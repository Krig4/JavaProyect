package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import object.Pedido;

public class PhpMyAdmin {
	String driver;
    String database;
    String hostname;
    String port;
    String url;
    String username;
    String password;
    Connection conn;
    
    public PhpMyAdmin() {
   	 this.hostname = "localhost";
   	 this.port = "3306";
   	 this.database = "finalexam";
   	 this.username = "root";
   	 this.password = "";
   	 this.driver = "com.mysql.cj.jdbc.Driver";
   	 this.url  = "jdbc:mysql://" + hostname + ":" + port + "/";
   	 try {
			this.conn = connect();
			String sql = "CREATE DATABASE IF NOT EXISTS " + this.database;
			PreparedStatement st = conn.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			this.conn.close();
			this.url = "jdbc:mysql://" + hostname + ":" + port + "/" + this.database;
			this.conn = connect();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public Connection connect() throws ClassNotFoundException {        
        try {
            Class.forName(this.driver);
            return DriverManager.getConnection(this.url, this.username, this.password);
        } catch ( SQLException e) {
       	 System.out.println("{");
            e.printStackTrace();
            System.out.println("}");
        }
        return null;
    }
    
    public void Add(String name, int price) {
		try {
			PreparedStatement pst = this.conn.prepareStatement("INSERT into product(name, price) VALUES (?, ?, ?)");
			pst.setString(1, name);
			pst.setInt(2, price);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void DeletePedido(int idPedido)
    {
    	try {
			PreparedStatement pst = this.conn.prepareStatement("Update pedido set isComplete=1, complete=? where id=?");
			pst.setString(1, LocalDateTime.now().toString());
			System.out.println("Hola:" + LocalDateTime.now().toString());
			pst.setInt(2, idPedido);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void DeletePlato(int idPlato)
    {
    	try {
			PreparedStatement pst = this.conn.prepareStatement("Delete from plato where id=?");
			pst.setInt(1, idPlato);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
