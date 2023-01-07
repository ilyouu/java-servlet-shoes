package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/dang-ky")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    
    public RegisterController() {
        super();
        userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(name, email, password, "user");
		try {
			userDAO.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("dang-nhap");
	}
}
