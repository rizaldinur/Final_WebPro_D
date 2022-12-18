package com.cateringlarissa.review.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cateringlarissa.review.dao.ReviewDAO;
import com.cateringlarissa.review.model.Review;


@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDAO reviewDAO;
	
	public void init() {
		reviewDAO = new ReviewDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertReview(request, response);
				break;
			case "/delete":
				deleteReview(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateReview(request, response);
				break;
			default:
				listReview(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Review> listReview = reviewDAO.selectAllReviews();
		request.setAttribute("listReview", listReview);
		RequestDispatcher dispatcher = request.getRequestDispatcher("review-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("review-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Review existingReview = reviewDAO.selectReview(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("review-form.jsp");
		request.setAttribute("review", existingReview);
		dispatcher.forward(request, response);

	}

	private void insertReview(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String description = request.getParameter("description");
		Review newReview = new Review(name, rating, description);
		reviewDAO.insertReview(newReview);
		response.sendRedirect("list");
	}

	private void updateReview(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String description = request.getParameter("description");

		Review book = new Review(id, name, rating, description);
		reviewDAO.updateReview(book);
		response.sendRedirect("list");
	}

	private void deleteReview(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reviewDAO.deleteReview(id);
		response.sendRedirect("list");

	}
}
