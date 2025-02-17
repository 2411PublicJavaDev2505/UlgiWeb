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
 * Servlet implementation class CustomerUpdateServlet
 */
@WebServlet("/customer/update")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userName = request.getParameter("userName");
		String addr = request.getParameter("addr");
		Customer customer = new Customer(userNo, userName, addr);
		CustomerService cService = new CustomerService();
		int result = cService.updateCustomer(customer);
		
		if(result > 0) {
			customer = cService.selectOneByUserNo(userNo);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/WEB-INF/views/customer/detail.jsp").forward(request, response);
		}else {
			
		}
		
		
	}

}
