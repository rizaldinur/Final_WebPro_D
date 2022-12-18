package com.cateringlarissa.menu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cateringlarissa.menu.model.Menu;

public class MenuDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcMenuname = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_MENUS_SQL = "INSERT INTO menus" + "  (name, type, description) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_MENU_BY_ID = "select id,name,type,description from menus where id =?";
	private static final String SELECT_ALL_MENUS = "select * from menus";
	private static final String DELETE_MENUS_SQL = "delete from menus where id = ?;";
	private static final String UPDATE_MENUS_SQL = "update menus set name = ?,type= ?, description =? where id = ?;";

	public MenuDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcMenuname, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertMenu(Menu menu) throws SQLException {
		System.out.println(INSERT_MENUS_SQL);
		

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MENUS_SQL)) {
			preparedStatement.setString(1, menu.getName());
			preparedStatement.setString(2, menu.getType());
			preparedStatement.setLong(3, menu.getPrice());
			preparedStatement.setString(4, menu.getDescription());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Menu selectMenu(int id) {
		Menu menu = null;
		
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MENU_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String name = rs.getString("name");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				menu = new Menu(id, name, type, price, description);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return menu;
	}

	public List<Menu> selectAllMenus() {


		List<Menu> menus = new ArrayList<>();

		try (Connection connection = getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MENUS);) {
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();


			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				menus.add(new Menu(id, name, type, price, description));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return menus;
	}

	public boolean deleteMenu(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MENUS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateMenu(Menu menu) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MENUS_SQL);) {
			statement.setString(1, menu.getName());
			statement.setString(2, menu.getType());
			statement.setString(3, menu.getDescription());
			statement.setInt(4, menu.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
