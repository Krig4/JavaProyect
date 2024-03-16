package paquetedatos;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import paqueteobjetos.Pedidos;
import paqueteobjetos.PintarHTML;
import paqueteobjetos.Platos;

public class accesodatos {
	private static Connection c= null;
	static StandardServiceRegistry s=null;
    static SessionFactory sf=null;
    
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


    private static void createConnectionHibernate() 
    {
        s=new StandardServiceRegistryBuilder().configure().build();
        sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
    }

    public static void grabarPlato(Platos plato) 
    {
        createConnectionHibernate();
        Session sesion=sf.openSession();
        Transaction t=sesion.beginTransaction();

        sesion.save(plato);
        t.commit();
        sesion.close();
    }
    
	public static ArrayList<Platos> recuperarPlatos()
    {
        createConnectionHibernate();
        Session sesion=sf.openSession();
        Query q=sesion.createQuery("FROM Platos");
        List lista_platos=q.getResultList();
        sesion.close();
         return (ArrayList<Platos>)lista_platos;

    }
	public static ArrayList<Pedidos> obtenerTodosPedidos() {
		createConnectionHibernate();
		Session sesion=sf.openSession();
		Query q=sesion.createQuery("FROM Pedidos");
		List lista_pedidos = q.getResultList();
		sesion.close();
	    return (ArrayList<Pedidos>)lista_pedidos;
	}
	public static void entregarPedido(Pedidos pedido) {
	    Configuration configuration = new Configuration().configure();
	    try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	    		Session session = sessionFactory.openSession()) {
	    	Transaction transaction = session.beginTransaction();
	    	session.update(pedido);
	        transaction.commit();
	    }
	}
	public static Pedidos obtenerPedidoPorId(int idPedido) {
		 Configuration configuration = new Configuration().configure();
	        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
	             Session session = sessionFactory.openSession()) {
	            Transaction transaction = session.beginTransaction();
	            String hql = "FROM Pedidos WHERE id = :id";
	            Query query = session.createQuery(hql);
	            query.setParameter("id", idPedido);
	            Pedidos pedido = (Pedidos) ((org.hibernate.query.Query) query).uniqueResult();

	            transaction.commit();
	            return pedido;
	        }

	}
	public static void borrarPlato(String idPlato) throws SQLException {
    	createConnection();
        Connection c = null;
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante?user=root");
        Statement stmt = c.createStatement();
        String sql = "DELETE FROM tabla_platos WHERE id = '" + idPlato + "'";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    }
    public static void insertarPedido(Pedidos p){
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
    public static void PedidosCSV(ArrayList<Pedidos> pedidos) {
		try {
			System.out.println("Creando csv");
			FileWriter fw = new FileWriter("C:\\datos\\pedidos.csv", true);
			fw.write("");
			fw.close();
			fw = new FileWriter("C:\\\\datos\\\\pedidos.csv", false);
			for (int i = 0; i < pedidos.size(); i += 1)
			{
				if (pedidos.get(i).getComplete() != null)
					fw.write(pedidos.get(i).getComplete().toString()+","+pedidos.get(i).getDate() + "," + pedidos.get(i).getMesa() + "," + pedidos.get(i).getPrimero() + "," + pedidos.get(i).getSegundo() + "," + pedidos.get(i).getPostre() + "," + pedidos.get(i).getObs() + "\n");
				else
					fw.write("No completado"+","+pedidos.get(i).getDate() + "," + pedidos.get(i).getMesa() + "," + pedidos.get(i).getPrimero() + "," + pedidos.get(i).getSegundo() + "," + pedidos.get(i).getPostre() + "," + pedidos.get(i).getObs() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
