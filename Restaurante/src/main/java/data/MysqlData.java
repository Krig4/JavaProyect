package data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import object.Pedido;
import object.Plato;
import object.User;

public class MysqlData {
	static StandardServiceRegistry s = null;
	static SessionFactory sf = null;
	
	public static void abrirConexion()
	{
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}
	
	public static void Save(Plato p) {
		try {
			abrirConexion();
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
	
	public static void Save(User u) {
		try {
			abrirConexion();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save( u);
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Save(Pedido p) {
		try {
			abrirConexion();
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
	
	public static ArrayList<Pedido> getPedidos()
	{
		abrirConexion();
		Session sesion=sf.openSession();
		Query q=sesion.createQuery("FROM Pedido");//SQL: Select... from TABLA
												//JPQL: form Entidad
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>) q.getResultList();
		sesion.close();
		return pedidos;
		
	}
	
	public static ArrayList<Plato> getPlatos()
	{
		abrirConexion();
		Session sesion=sf.openSession();
		Query q=sesion.createQuery("FROM Plato");//SQL: Select... from TABLA
												//JPQL: form Entidad
		ArrayList<Plato> platos = (ArrayList<Plato>) q.getResultList();
		sesion.close();
		return platos;
	}
	
	public static ArrayList<User> getUsers()
	{
		abrirConexion();
		Session sesion=sf.openSession();
		Query q=sesion.createQuery("FROM User");//SQL: Select... from TABLA
												//JPQL: form Entidad
		ArrayList<User> users = (ArrayList<User>) q.getResultList();
		sesion.close();
		return users;
	}
	
	public static void PedidosCSV(ArrayList<Pedido> pedidos) {
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
