package co.edu.ufps.tienda.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.tienda.dao.TiendaDAO;
import co.edu.ufps.tienda.dao.GenericDao;
import co.edu.ufps.tienda.entity.Tienda;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/TiendaServlet")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TiendaDAO tiendaDAO;

	private GenericDao<Tienda> u;

	public TiendaServlet() {
		super();
	}

	public void init() {

		tiendaDAO = new TiendaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;

			case "register":
				insert(request, response);
				break;

			case "delete":
				delete(request, response);
				break;

			case "showedit":
				showEditForm(request, response);
				break;

			case "editar":
				update(request, response);
				break;

			default:
				System.out.println("c");
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		List<Tienda> list = tiendaDAO.list();

		RequestDispatcher dispatcher = null;
		String email = request.getParameter("email");
		boolean existe = false;
		for (Tienda t : list) {
			if (t.getEmail().equals(email)) {
				existe = true;
			}
		}

		if (!existe) {
			String nombre = request.getParameter("nombre");
			String lema = request.getParameter("lema");
			String descripcion = request.getParameter("descripcion");

			String pass = request.getParameter("pass");
			String propietario = request.getParameter("propietario");
			String facebook = request.getParameter("facebook");
			String web = request.getParameter("web");
			String imagen = request.getParameter("imagen");
			Tienda tienda = new Tienda(null, nombre, lema, descripcion, email, pass, propietario, facebook, web, imagen,
					null, null);

			tiendaDAO.insert(tienda);

			 dispatcher = request.getRequestDispatcher("index.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("registro.jsp");
			String mensaje="No se pudo registrar";
			request.setAttribute("mensaje", mensaje);
		}
		dispatcher.forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tienda> list = tiendaDAO.list();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tienda tienda = tiendaDAO.find(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		request.setAttribute("tienda", tienda);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");

		Tienda tienda = tiendaDAO.find(id);

		tienda.setNombre(nombre);

		tiendaDAO.update(tienda);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mostrar.jsp");
		dispatcher.forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String codigo = request.getParameter("codigo");
		Tienda tienda = tiendaDAO.find(codigo);
		tiendaDAO.delete(tienda);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmpleadoServlet?action=mostrar");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
