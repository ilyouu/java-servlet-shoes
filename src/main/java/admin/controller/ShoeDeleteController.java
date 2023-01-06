package admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.ShoeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/admin-shoes-delete")
public class ShoeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoeDAO giayDAO;
  
    public ShoeDeleteController() {
        super();
        giayDAO = new ShoeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			giayDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin-shoes");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
