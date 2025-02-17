package com.ulgi.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ulgi.book.model.service.BookService;

/**
 * Servlet implementation class BookDeleteServlet
 */
@WebServlet("/book/delete")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Boolean.parseBoolean(request.getParameter("del"))) {
			BookService bService = new BookService();
			int bookNo = (request.getParameter("bookNo") != null)
					? Integer.parseInt(request.getParameter("bookNo")) : 0;
			int result = bService.deleteBook(bookNo);
			
			if(result>0) {
				response.sendRedirect("/book/list");
			}else {
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("/book/list");
		}
	}

}
