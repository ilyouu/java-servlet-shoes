package web.controller;

import java.io.IOException;
import java.util.List;

import dao.ShoeDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/trang-chu")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoeDAO giayDAO;
	
    public HomeController() {
        super();
        giayDAO = new ShoeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Shoe> giays = giayDAO.selectAll();
		request.setAttribute("giays", giays);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/home.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
