package web.controller;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/dang-nhap")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
    public LoginController() {
        super();
        userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			response.sendRedirect("admin");
		} else {
			List<User> users = userDAO.selectAll();
			for (User user : users) {
				if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
					
				}
			}
			response.sendRedirect("");
		}
	}

}
