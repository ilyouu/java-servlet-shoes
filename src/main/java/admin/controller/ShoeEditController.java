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

@WebServlet(urlPatterns = "/admin-shoes-edit")
public class ShoeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoeDAO giayDAO;
  
    public ShoeEditController() {
        super();
        giayDAO = new ShoeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Shoe giay = giayDAO.select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/shoes-edit.jsp");
		request.setAttribute("giay", giay);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_giay = Integer.parseInt(request.getParameter("id_giay"));
		String ten_giay = request.getParameter("ten_giay");
		String ten_loai_giay = request.getParameter("ten_loai_giay");
		String thuong_hieu = request.getParameter("ten_thuong_hieu");
		String mo_ta = request.getParameter("mo_ta");
		String don_gia = request.getParameter("don_gia");
		String hinh_anh_1 = request.getParameter("hinh_anh_1");
		String hinh_anh_2 = request.getParameter("hinh_anh_2");
		String hinh_anh_3 = request.getParameter("hinh_anh_3");
		String hinh_anh_4 = request.getParameter("hinh_anh_4");
		Shoe giay = new Shoe(id_giay, ten_giay, ten_loai_giay, thuong_hieu, mo_ta, don_gia, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4);
		try {
			if (giay != null)
			giayDAO.update(giay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin-shoes");
	}
	
}
