package com.ulgi.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ulgi.book.model.service.BookService;
import com.ulgi.book.model.vo.Book;

/**
 * Servlet implementation class BookInsertServlet
 */
@WebServlet("/book/insert")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/book/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int	   bookNo 	  = Integer.parseInt(request.getParameter("bookNo"));
		String bookName   = request.getParameter("bookName");
		String bookWriter = request.getParameter("bookWriter");
		int    bookPrice  = Integer.parseInt(request.getParameter("bookPrice"));
		String publisher  = request.getParameter("publisher");
		String genre	  = request.getParameter("genre");
		Book book = new Book(bookNo, bookName, bookWriter, bookPrice, publisher, genre);
		int result = new BookService().insertBook(book);
		if(result > 0) {
			response.sendRedirect("/book/list");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
		
		
	}

}
