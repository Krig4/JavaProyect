package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.MysqlData;
import data.PhpMyAdmin;
import object.Pedido;
import object.Plato;
import object.User;

/**
 * Servlet implementation class ExamServlet
 */
@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		switch(request.getParameter("action")) {
			case "login":{
				ArrayList<User> users = MysqlData.getUsers();
				if (users != null)
				{
					for (int i = 0; i < users.size(); i += 1)
					{
						if (users.get(i).getUsername().equals(request.getParameter("username")))
						{
							if (users.get(i).getPassword().equals(request.getParameter("password")))
							{
								System.out.println("Bien logeado");
								HttpSession session = request.getSession(true);
								session.setAttribute("username", "cocinero");
								session.setAttribute("id", "1");								
								request.setAttribute("pedidos", MysqlData.getPedidos());
								request.getRequestDispatcher("mostrarPedidos.jsp").forward(request, response);
							}
							else
							{
								request.setAttribute("error", "Error de credenciales");
								request.getRequestDispatcher("login.jsp").forward(request, response);
							}
						}
						else
						{
							request.setAttribute("error", "Error de credenciales");
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
					}
				}
				else
				{
					System.out.println("No existen usuarios");
					request.setAttribute("error", "loginError");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				break;
			}
			case "borrar":
			{
				request.setAttribute("platos", MysqlData.getPlatos());
				request.getRequestDispatcher("borrarPlatos.jsp").forward(request, response);
				break;
			}
			case "mostrarPedidos":
			{
				MysqlData.PedidosCSV(MysqlData.getPedidos());
				request.setAttribute("pedidos", MysqlData.getPedidos());
				request.getRequestDispatcher("mostrarPedidos.jsp").forward(request, response);
				break;
			}
			case "ingresarPlato":
			{
				String name = request.getParameter("name");
				String type = request.getParameter("type");
				int price = Integer.parseInt(request.getParameter("price"));
				MysqlData.Save(new Plato(name, price, type));
				request.setAttribute("platos", MysqlData.getPlatos());
				request.getRequestDispatcher("borrarPlatos.jsp").forward(request, response);
				break;
			}
			case "solicitar":
			{
				String primero = request.getParameter("primero");
				String segundo = request.getParameter("segundo");
				String postre = request.getParameter("postre");
				String mesa = request.getParameter("mesa");
				String obs = request.getParameter("obs");
				
				request.setAttribute("primero", primero);
				request.setAttribute("segundo", segundo);
				request.setAttribute("postre", postre);
				request.setAttribute("mesa", mesa);
				request.setAttribute("obs", obs);
				request.setAttribute("platos", MysqlData.getPlatos());
				
				request.getRequestDispatcher("mostrarTotal.jsp").forward(request, response);
			}
			case "savePedido":
			{
				String primero = request.getParameter("primero");
				String segundo = request.getParameter("segundo");
				String postre = request.getParameter("postre");
				String mesa = request.getParameter("mesa");
				String obs = request.getParameter("obs");
				
				MysqlData.Save(new Pedido(primero, segundo, postre, Integer.parseInt(mesa), obs));
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			case "borrarPedido":
			{
				String id = request.getParameter("idPedido");
				PhpMyAdmin php = new PhpMyAdmin();
				ArrayList<Pedido> ps = MysqlData.getPedidos();
				Pedido p = null;
				for(int i = 0; i < ps.size(); i += 1)
					if (ps.get(i).getId() == Integer.parseInt(id))
						p = ps.get(i);
				php.DeletePedido(p.getId());
				request.setAttribute("pedidos", MysqlData.getPedidos());
				request.getRequestDispatcher("mostrarPedidos.jsp").forward(request, response);
			}
			case "borrarPlato":
			{
				String id = request.getParameter("idPlato");
				PhpMyAdmin php = new PhpMyAdmin();
				ArrayList<Plato> ps = MysqlData.getPlatos();
				Plato p = null;
				for(int i = 0; i < ps.size(); i += 1)
					if (ps.get(i).getId() == Integer.parseInt(id))
						p = ps.get(i);
				php.DeletePlato(p.getId());
				request.setAttribute("platos", MysqlData.getPlatos());
				request.getRequestDispatcher("borrarPlatos.jsp").forward(request, response);
			}
			case "csv":
			{
				MysqlData.PedidosCSV(MysqlData.getPedidos());
				request.setAttribute("pedidos", MysqlData.getPedidos());
				request.getRequestDispatcher("mostrarPedidos.jsp").forward(request, response);
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
