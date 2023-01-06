package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Shoe;

public class ShoeDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/pvbshoesshop?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO shoes" + " (ten_giay, ten_loai_giay, ten_thuong_hieu, mo_ta, don_gia, "
			+ "hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT = "select * from shoes where id_giay = ?;";
	private static final String SELECT_ALL = "select * from shoes;";
	private static final String DELETE= "delete from shoes where id_giay = ?;";
	private static final String UPDATE = "update shoes set ten_giay = ?, ten_loai_giay = ?, ten_thuong_hieu = ?, mo_ta = ?, don_gia = ?, "
			+ "hinh_anh_1 = ?, hinh_anh_2 = ?, hinh_anh_3 = ?, hinh_anh_4 = ? where id_giay = ?;";

	public ShoeDAO() { }
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insert(Shoe giay) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, giay.getTen_giay());
			preparedStatement.setString(2, giay.getTen_loai_giay());
			preparedStatement.setString(3, giay.getTen_thuong_hieu());
			preparedStatement.setString(4, giay.getMo_ta());
			preparedStatement.setString(5, giay.getDon_gia());
			preparedStatement.setString(6, giay.getHinh_anh_1());
			preparedStatement.setString(7, giay.getHinh_anh_2());
			preparedStatement.setString(8, giay.getHinh_anh_3());
			preparedStatement.setString(9, giay.getHinh_anh_4());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public Shoe select(int id) {
		Shoe giay = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ten_giay = rs.getString("ten_giay");
				String ten_loai_giay = rs.getString("ten_loai_giay");
				String ten_thuong_hieu = rs.getString("ten_thuong_hieu");
				String mo_ta = rs.getString("mo_ta");
				String don_gia = rs.getString("don_gia");
				String hinh_anh_1 = rs.getString("hinh_anh_1");
				String hinh_anh_2 = rs.getString("hinh_anh_2");
				String hinh_anh_3 = rs.getString("hinh_anh_3");
				String hinh_anh_4 = rs.getString("hinh_anh_4");
				
				giay = new Shoe(id, ten_giay, ten_loai_giay, ten_thuong_hieu, mo_ta, don_gia, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return giay;
	}

	public List<Shoe> selectAll() {
		List<Shoe> giays = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id_giay");
				String ten_giay = rs.getString("ten_giay");
				String ten_loai_giay = rs.getString("ten_loai_giay");
				String ten_thuong_hieu = rs.getString("ten_thuong_hieu");
				String mo_ta = rs.getString("mo_ta");
				String don_gia = rs.getString("don_gia");
				String hinh_anh_1 = rs.getString("hinh_anh_1");
				String hinh_anh_2 = rs.getString("hinh_anh_2");
				String hinh_anh_3 = rs.getString("hinh_anh_3");
				String hinh_anh_4 = rs.getString("hinh_anh_4");
				giays.add(new Shoe(id, ten_giay, ten_loai_giay, ten_thuong_hieu, mo_ta, don_gia, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return giays;
	}

	public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean update(Shoe giay) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE);) {
			statement.setString(1, giay.getTen_giay());
			statement.setString(2, giay.getTen_loai_giay());
			statement.setString(3, giay.getTen_thuong_hieu());
			statement.setString(4, giay.getMo_ta());
			statement.setString(5, giay.getDon_gia());
			statement.setString(6, giay.getHinh_anh_1());
			statement.setString(7, giay.getHinh_anh_2());
			statement.setString(8, giay.getHinh_anh_3());
			statement.setString(9, giay.getHinh_anh_4());
			statement.setInt(10, giay.getId_giay());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
