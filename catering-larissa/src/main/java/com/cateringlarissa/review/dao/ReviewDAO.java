package com.cateringlarissa.review.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cateringlarissa.review.model.Review;

public class ReviewDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcReviewname = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_REVIEWS_SQL = "INSERT INTO reviews" + "  (name, rating, description) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_REVIEW_BY_ID = "select id,name,rating,description from reviews where id =?";
	private static final String SELECT_ALL_REVIEWS = "select * from reviews";
	private static final String DELETE_REVIEWS_SQL = "delete from reviews where id = ?;";
	private static final String UPDATE_REVIEWS_SQL = "update reviews set name = ?,rating= ?, description =? where id = ?;";

	public ReviewDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcReviewname, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertReview(Review review) throws SQLException {
		System.out.println(INSERT_REVIEWS_SQL);
		

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEWS_SQL)) {
			preparedStatement.setString(1, review.getName());
			preparedStatement.setLong(2, review.getRating());
			preparedStatement.setString(3, review.getDescription());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Review selectReview(int id) {
		Review review = null;
		
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String name = rs.getString("name");
				int rating = rs.getInt("rating");
				String description = rs.getString("description");
				review = new Review(id, name, rating, description);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return review;
	}

	public List<Review> selectAllReviews() {


		List<Review> reviews = new ArrayList<>();

		try (Connection connection = getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEWS);) {
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();


			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int rating = rs.getInt("rating");
				String description = rs.getString("description");
				reviews.add(new Review(id, name, rating, description));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return reviews;
	}

	public boolean deleteReview(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEWS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateReview(Review review) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEWS_SQL);) {
			statement.setString(1, review.getName());
			statement.setLong(2, review.getRating());
			statement.setString(3, review.getDescription());
			statement.setInt(4, review.getId());

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
