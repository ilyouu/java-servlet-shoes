package admin.controller;

import java.io.IOException;
import java.util.List;

import dao.ShoeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/admin-shoes")
public class ShoeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoeDAO giayDAO;
	
    public ShoeController() {
        super();
        giayDAO = new ShoeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Shoe> giays = giayDAO.selectAll();
		request.setAttribute("giays", giays);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/shoes.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
