package com.ulgi.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ulgi.lease.model.service.LeaseService;

/**
 * Servlet implementation class LeaseDeleteServlet
 */
@WebServlet("/lease/delete")
public class LeaseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaseDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(Boolean.parseBoolean(request.getParameter("del"))) {
			int leaseNo = Integer.parseInt(request.getParameter("leaseNo"));
			int result = new LeaseService().deleteByLeaseNo(leaseNo);
			
			if(result > 0) {
				response.sendRedirect("/lease/list");
			}else {
				request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("/lease/list");
		}
	}

}
