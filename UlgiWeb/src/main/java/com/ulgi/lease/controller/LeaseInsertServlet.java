package com.ulgi.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.ulgi.lease.model.service.LeaseService;
import com.ulgi.lease.model.vo.Library;

/**
 * Servlet implementation class LeaseInsertServlet
 */
@WebServlet("/lease/insert")
public class LeaseInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaseInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		List<String> bookNameList = lService.selectBookNameList();
		List<String> userIdList = lService.selectUserIdList();
		request.setAttribute("bList", bookNameList);
		request.setAttribute("uList", userIdList);
		request.getRequestDispatcher("/WEB-INF/views/lease/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		
		
		int bookNo = lService.selectBookNoByName(request.getParameter("bookName"));
		String userId = request.getParameter("userId");
		Library library = new Library(bookNo, userId);
		
		int result = lService.insertLease(library);
		if( result > 0) {
			response.sendRedirect("/lease/list");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
