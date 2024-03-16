

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paqueteaccesodatos.AccesoDatos;
import paqueteaccesodatos.Contacto;

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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion = request.getParameter("accion");
		if(accion != null)
		{
			if(accion.equals("escribir")) 
			{
				String nombre = request.getParameter("name");
				String edad = request.getParameter("age");
				String telefono = request.getParameter("tel");
				Contacto nuevoContacto = new Contacto(nombre, edad, telefono);
				AccesoDatos.insertarContacto(nuevoContacto);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	        else if(accion.equals("listar"))
	        {
	        	ArrayList<Contacto> agenda = new ArrayList<>();
	        	agenda=AccesoDatos.recuperarContactos();
	        	 request.setAttribute("listaContacto", agenda);
	 			request.getRequestDispatcher("vercontacto.jsp").forward(request, response);
	        }else if (accion.equals("buscar")) 
	        {
	        	 String nombreBuscado = request.getParameter("search");
	             String route = "C:\\Users\\madrid\\eclipse-workspace\\AplicacionServer\\datos.csv";  
	             ArrayList<Contacto> contactosEncontrados = AccesoDatos.buscarContactos(nombreBuscado, route);
	             request.setAttribute("contactosEncontrados", contactosEncontrados);
	             request.getRequestDispatcher("mostrarContacto.jsp").forward(request, response);
	        }else if(accion.equals("borrar")) 
	        {
	        	String tlf=request.getParameter("telefono");
	        	ArrayList<Contacto> lista = new ArrayList<Contacto>();
	        	lista=AccesoDatos.Borrar(tlf);
	        	request.setAttribute("listaContacto", lista);
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
