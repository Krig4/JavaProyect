package Metodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoDatos {
private static String url_mysql = "jdbc:mysql://localhost:3306/gimnasio?user=root";
public static void insertarCliente(Usuario u) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_mysql);
		Statement stmt = conn.createStatement();
		String sql ="INSERT INTO t_usuarios(user, password) VALUES('" + u.getUsuario() + "','" + u.getPassword() + "')";
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public static void insertarEjercicio(Ejercicio ej) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_mysql);
		Statement stmt = conn.createStatement();
		String sql ="INSERT INTO t_ejercicios(ejercicios) VALUE('" + ej.getEjercicio() + "')";
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public static void insertarEntrenamiento(Entrenamiento ent) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url_mysql);
		Statement stmt = conn.createStatement();
		String sql ="INSERT INTO t_entrenamiento(ent1, ent2, ent3, ent4, usuario, fecha) VALUE('" + ent.getEnt1()  + "','" + ent.getEnt2()  + "','" + ent.getEnt3()  + "','" + ent.getEnt4()  + "','" + ent.getUsuario()  + "','" + ent.getFecha()  + "')";
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

}
