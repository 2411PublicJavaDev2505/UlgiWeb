package com.ulgi.customer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ulgi.customer.model.service.CustomerService;
import com.ulgi.customer.model.vo.Customer;

/**
 * Servlet implementation class CustomerDetailServlet
 */
@WebServlet("/customer/detail")
public class CustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		Customer cus = new CustomerService().selectOneByUserNo(userNo);
		if(cus != null) {
			request.setAttribute("customer", cus);
			request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/customer/error.jsp").forward(request, response);
		}
	}
}

