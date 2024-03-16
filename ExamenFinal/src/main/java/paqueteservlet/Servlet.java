package paqueteservlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquetedatos.accesodatos;
import paqueteobjetos.Pedidos;
import paqueteobjetos.Platos;


/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		switch(accion)
		{
		case "login":
			login(request, response);
			break;
		case "crearPlatos":
			crearPlatos(request, response);
			break;
		case "borrar":
        	try {
				borrarPlato(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "crearPedido":
			crearPedido(request, response);
			break;
		case "entregarPedido":
			entregarPedido(request, response);
			break;
		case "exportarCSV":
			csv(request, response);
			break;
		}

	}
	private void entregarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("idPedido"));
	    Pedidos pedido = accesodatos.obtenerPedidoPorId(productId);
	    if (pedido.getIsComplete() == 0) {
	    	pedido.setIsComplete(1);
	    	pedido.setComplete(LocalDateTime.now());
	        accesodatos.entregarPedido(pedido);
	        response.sendRedirect("verpedidos.jsp");
	    } else {
	        response.getWriter().println("Producto no disponible");
	    }
	}
	private void borrarPlato(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String idPlato = request.getParameter("idPlato");
		accesodatos.borrarPlato(idPlato);
		ArrayList<Platos> lista = accesodatos.recuperarPlatos();
        request.setAttribute("lista_platos", lista);
        request.getRequestDispatcher("borrarPlato.jsp").forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
		if ("admin".equals(user) && "1234".equals(pass)) {
			try {
				request.getRequestDispatcher("insertarplatos.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void crearPlatos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nombre=request.getParameter("nombre");
		String tipo = request.getParameter("tipo");
		String precio = request.getParameter("precio");
		try {
			Platos platos = new Platos(tipo, nombre, precio, 0);
			accesodatos.grabarPlato(platos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void crearPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedidos p = null;
		String primero = request.getParameter("primerPlato");
		String segundo = request.getParameter("segundoPlato");
		String postre = request.getParameter("postre");
		String observaciones = request.getParameter("observacion");
		String mesa = request.getParameter("mesa");	
		LocalDateTime l = LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anyo=l.getYear();
		String fecha=dia+"/"+mes+"/"+anyo;
		p = new Pedidos(0, mesa, primero, segundo, postre, observaciones);
		accesodatos.insertarPedido(p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	private void csv(HttpServletRequest request, HttpServletResponse response) {
		accesodatos.PedidosCSV(accesodatos.obtenerTodosPedidos());
		request.setAttribute("pedidos", accesodatos.obtenerTodosPedidos());
		try {
			request.getRequestDispatcher("verpedidos.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
