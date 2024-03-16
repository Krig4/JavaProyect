package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Metodos.AccesoDatos;
import Metodos.Usuario;
import Metodos.Ejercicio;


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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion = request.getParameter("accion");
		if(accion != null) {
			if(accion.equals("registro")) {
				String usuario = request.getParameter("user");
				String password = request.getParameter("password");
				Usuario nuevoUsuario = new Usuario(usuario,password);
				AccesoDatos.insertarCliente(nuevoUsuario);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else if(accion.equals("login")) {
				String usuario = request.getParameter("user");
				String password = request.getParameter("password");
				if (usuario.equals("master") && password.equals("1234")) {
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
				} else{
					
				}
			} else if(accion.equals("ejercicio")) {
				String ejercicio = request.getParameter("ejercicio");
				Ejercicio nuevoEjercicio = new Ejercicio(ejercicio);
				AccesoDatos.insertarEjercicio(nuevoEjercicio);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
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
