package com.ulgi.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ulgi.lease.model.service.LeaseService;
import com.ulgi.lease.model.vo.Library;

/**
 * Servlet implementation class LeaseDetailServlet
 */
@WebServlet("/lease/detail")
public class LeaseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaseDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int leaseNo = Integer.parseInt(request.getParameter("leaseNo"));
		Library library = new LeaseService().selectOneByLeaseNo(leaseNo);
		if( library != null) {
			request.setAttribute("library", library);
			request.getRequestDispatcher("/WEB-INF/views/lease/detail.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/views/lease/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
