package paquetedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import paqueteobjetos.Cocinero;
import paqueteobjetos.Pedido;
import paqueteobjetos.Plato;

public class AccesoDatos {
	
	private static Connection c=null;
	private static void createConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante?user=root");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertarCocinero(Cocinero cocinero) {
		Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cocinero);
            transaction.commit();
        }
	}

	public static Cocinero obtenerCocinero(String nombre, String pass) {
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		         Session session = sessionFactory.openSession()) {

		        String hql = "FROM Cocinero WHERE nombre = :nombre AND pass = :pass";
		        Query<Cocinero> query = session.createQuery(hql);
		        query.setParameter("nombre", nombre);
		        query.setParameter("pass", pass);
		        Cocinero cocinero = query.uniqueResult();

		        return cocinero;
		    }
	}

	public static void crearPlato(Plato plato) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(plato);
            transaction.commit();
        }
	}
	
	public static ArrayList<Plato> obtenerTodosPlatos() {
	    try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	         Session session = sessionFactory.openSession()) {

	        String hql = "FROM Plato";
	        Query<Plato> query = session.createQuery(hql, Plato.class);
	        List<Plato> productList = query.list();

	        return new ArrayList<>(productList);
	    }
	}

	public static void crearPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        }
	}
	
	public static ArrayList<Pedido> obtenerTodosPedidos() {
	    try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	         Session session = sessionFactory.openSession()) {

	        String hql = "FROM Pedido";
	        Query<Pedido> query = session.createQuery(hql, Pedido.class);
	        List<Pedido> productList = query.list();

	        return new ArrayList<>(productList);
	    }
	}

	public static void entregarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
	    Configuration configuration = new Configuration().configure();
	    try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	    		Session session = sessionFactory.openSession()) {
	    	Transaction transaction = session.beginTransaction();
	    	session.update(pedido);

	        transaction.commit();
	    }
	}

	public static Pedido obtenerPedidoPorId(int idPedido) {
		// TODO Auto-generated method stub
		
		 Configuration configuration = new Configuration().configure();
	        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	             Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();

	            String hql = "FROM Pedido WHERE id = :id";
	            Query<Pedido> query = session.createQuery(hql);
	            query.setParameter("id", idPedido);
	            Pedido pedido = query.uniqueResult();

	            transaction.commit();
	            return pedido;
	        }

	}
	
	public static void eliminarPlato(int id) {
	    createConnection();
	    try {
	        Statement stmt = c.createStatement();
	        String sql = "DELETE FROM Plato WHERE id = " + id;
	        int rowsAffected = stmt.executeUpdate(sql);

	        if (rowsAffected > 0) {
	            System.out.println("Plato eliminado exitosamente.");
	        } else {
	            System.out.println("No se encontró ningún plato con el ID proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection();
	    }
	}
	
	
	private static void closeConnection() {
	    try {
	        if (c != null) {
	            c.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	

}
