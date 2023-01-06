package admin.controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.ShoeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Shoe;
import model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/admin-shoes-add")
public class ShoeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoeDAO giayDAO;
  
    public ShoeAddController() {
        super();
        giayDAO = new ShoeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/shoes-add.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_giay = request.getParameter("ten_giay");
		String ten_loai_giay = request.getParameter("ten_loai_giay");
		String thuong_hieu = request.getParameter("ten_thuong_hieu");
		String mo_ta = request.getParameter("mo_ta");
		String don_gia = request.getParameter("don_gia");
		String hinh_anh_1 = "giay" +randomNum()+".jpg";
		String hinh_anh_2 = "giay" +randomNum()+".jpg";
		String hinh_anh_3 = "giay" +randomNum()+".jpg";
		String hinh_anh_4 = "giay" +randomNum()+".jpg";
		Shoe giay = new Shoe(ten_giay, ten_loai_giay, thuong_hieu, mo_ta, don_gia, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4);
		try {
			if (giay != null)
			giayDAO.insert(giay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin-shoes");
	}
	
	public String randomNum() {
		int min = 1; 
		int max = 23; 
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return Integer.toString(random_int);
	}
}
