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
 * Servlet implementation class CustomerInsertServlet
 */
@WebServlet("/customer/insert")
public class CustomerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/customer/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cService = new CustomerService();
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		
		String  userId = request.getParameter("userId"); 
		String  userName = request.getParameter("userName"); 
		String  addr = request.getParameter("addr"); 
		String  gender = request.getParameter("gender"); 
		 
		
		Customer cus = new Customer(userNo, userId, userName, userAge, addr, gender, null);
		
		int result = cService.insertCustomer(cus);
		if(result > 0) {
			response.sendRedirect("/customer/list");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		
	}

	}	
}
