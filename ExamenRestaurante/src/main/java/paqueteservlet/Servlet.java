package paqueteservlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquetedatos.AccesoDatos;
import paqueteobjetos.*;
import paqueteobjetos.Cocinero;

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
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		
		if(accion != null && accion.equals("crearCocinero")) {
			insertarCocinero(request, response);
		}
		if(accion != null && accion.equals("loginCocinero")) {
			loginCocinero(request, response);
		}
		if(accion != null && accion.equals("crearPlato")) {
			crearPlato(request, response);
		}
		if(accion != null && accion.equals("crearPedido")) {
			crearPedido(request, response);
		}
		if(accion != null && accion.equals("entregarPedido")) {
			entregarPedido(request, response);
		}
		if(accion != null && accion.equals("borrarPlato")) {
			borrarPlato(request, response);
		}
		
	}

	

	private void insertarCocinero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("name");
        String pass = request.getParameter("pwd");

        Cocinero cocinero = new Cocinero(nombre, pass);

        AccesoDatos.insertarCocinero(cocinero);
    }

	private void loginCocinero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nameLog");
        String pass = request.getParameter("pwdLog");

        Cocinero cocinero = AccesoDatos.obtenerCocinero(nombre, pass);

        if (cocinero != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("cocinero", cocinero);
            
            session.setAttribute("nombreCocinero", cocinero.getNombre());
            
            request.getRequestDispatcher("verPedidos.jsp").forward(request, response);

        } else {
            response.getWriter().println("Error de autenticación");
        }
	}
	
	private void crearPlato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletRequest session = null;
		// TODO Auto-generated method stub

		String nombre = request.getParameter("name");
		int precio = Integer.parseInt(request.getParameter("price"));
		String tipo = request.getParameter("type");
		
		Plato plato = new Plato(nombre, precio, tipo);
		
		AccesoDatos.crearPlato(plato);
		
        request.getRequestDispatcher("crearPlato.jsp").forward(request, response);

	}
	
	private void obtenerTodosPlatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Plato> lista_platos = AccesoDatos.obtenerTodosPlatos();
        request.setAttribute("lista_platos", lista_platos);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
	}
	
	private void crearPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numMesa = Integer.parseInt(request.getParameter("numMesa"));
		String primero = request.getParameter("primerPlato");
		String segundo = request.getParameter("segundoPlato");
		String postre = request.getParameter("postre");
		String observacion = request.getParameter("obs");
		LocalDateTime l = LocalDateTime.now();
        int dia = l.getDayOfMonth();
        int mes = l.getMonthValue();
        int anyo = l.getYear();
        String fecha = dia + "/" + mes + "/" + anyo;
		Pedido pedido = new Pedido(fecha, numMesa, primero, segundo, postre, observacion, false);
		
		AccesoDatos.crearPedido(pedido);
		
        request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void entregarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("idPedido"));

	    Pedido pedido = AccesoDatos.obtenerPedidoPorId(productId);

	    if (pedido.getEntregado() == false) {
	    	pedido.setEntregado(true);

	        AccesoDatos.entregarPedido(pedido);

	        response.sendRedirect("verPedidos.jsp");
	    } else {
	        response.getWriter().println("Producto no disponible");
	    }
	}
	
	private void borrarPlato(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int idPlato = Integer.parseInt(request.getParameter("idPlato"));
		
		AccesoDatos.eliminarPlato(idPlato);
		
        response.sendRedirect("borrarPlatos.jsp");

	}
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
