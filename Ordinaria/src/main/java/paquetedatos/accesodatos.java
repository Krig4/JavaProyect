package paquetedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import paqueteobjetos.Entradas;
import paqueteobjetos.Reservas;

public class accesodatos {
	private static Connection c= null;
	static StandardServiceRegistry s=null;
    static SessionFactory sf=null;
    
    private static void createConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/discoteca?user=root");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void createConnectionHibernate() 
    {
        s=new StandardServiceRegistryBuilder().configure().build();
        sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
    }
    public static String checkUser(String usuario, String password) {
		createConnection();
		String rol=null;
		try {
			PreparedStatement pstmt=c.prepareStatement("SELECT rol FROM tabla_usuarios WHERE usuario=? AND password=?");
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
			rol=rs.getString("rol");
			return rol;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
    public static ArrayList<Entradas> recuperarReservas()
    {
        createConnectionHibernate();
        Session sesion=sf.openSession();
        Query q=sesion.createQuery("FROM Entradas");
        List lista_entradas=q.getResultList();
        sesion.close();
         return (ArrayList<Entradas>)lista_entradas;

    }
    public static ArrayList<Reservas> obtenerTodosPedidos() {
		createConnectionHibernate();
		Session sesion=sf.openSession();
		Query q=sesion.createQuery("FROM Reservas");
		List lista_reservas = q.getResultList();
		sesion.close();
	    return (ArrayList<Reservas>)lista_reservas;
	}
    public static void insertarPedido(Reservas p){
    	try {
    		createConnectionHibernate();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save( p );
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
