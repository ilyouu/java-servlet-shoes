package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3366/pvbshoesshop?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456";

	private static final String INSERT = "INSERT INTO users" + " (ten_nguoi_dung, email, password, phan_quyen) VALUES (?, ?, ?, ?);";
	private static final String SELECT = "select * from users where id = ?;";
	private static final String SELECT_ALL = "select * from users;";
	private static final String DELETE= "delete from users where id = ?;";
	private static final String UPDATE = "update users set ten_nguoi_dung = ?, email = ?, password = ?, phan_quyen = ? where id = ?;";

	public UserDAO() { }
	
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

	public void insert(User user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setString(1, user.getTen_nguoi_dung());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhan_quyen());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public User select(int id) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String ten_nguoi_dung = rs.getString("ten_nguoi_dung");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String phan_quyen = rs.getString("phan_quyen");
				
				user = new User(id, ten_nguoi_dung, email, password, phan_quyen);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return user;
	}

	public List<User> selectAll() {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String ten_nguoi_dung = rs.getString("ten_nguoi_dung");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String phan_quyen = rs.getString("phan_quyen");
				
				users.add(new User(id, ten_nguoi_dung, email, password, phan_quyen));
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		return users;
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

	public boolean update(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE);) {
			statement.setString(1, user.getTen_nguoi_dung());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getPhan_quyen());
			statement.setInt(5, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
