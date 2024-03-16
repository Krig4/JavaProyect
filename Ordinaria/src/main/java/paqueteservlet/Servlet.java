package paqueteservlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paquetedatos.accesodatos;
import paqueteobjetos.Entradas;
import paqueteobjetos.Reservas;

/**
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
		HttpSession session = request.getSession(true);
		switch(accion)
		{
		case "login":
			gestionarLogin(request, response, session);
			break;
		case "crearPedido":
			crearPedido(request, response, session);
			break;
		}
		
	}
	private void crearPedido(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		String usuario = (String) session.getAttribute("usuario");
		Reservas p = null;
		String entrada = request.getParameter("entrada");	
		LocalDateTime l = LocalDateTime.now();
		int dia=l.getDayOfMonth();
		int mes=l.getMonthValue();
		int anyo=l.getYear();
		String fecha=dia+"/"+mes+"/"+anyo;
		p = new Reservas(0, usuario, fecha, entrada);
		accesodatos.insertarPedido(p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		private void gestionarLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
			String usuario=request.getParameter("usuario");
			String password=request.getParameter("password");
			String rol=accesodatos.checkUser(usuario, password);
			if (rol==null)
			{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			if (rol.equals("admin"))
			{
				session.setAttribute("usuario", usuario);
				session.setAttribute("rol", "admin");
				request.setAttribute("master", "OK");
				request.getRequestDispatcher("verReservas.jsp").forward(request, response);
				
			}
			else if(rol.equals("user"))
			{
				session.setAttribute("usuario", usuario);
				session.setAttribute("rol", "user");
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("comprar.jsp").forward(request, response);;
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
