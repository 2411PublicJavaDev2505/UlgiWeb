package com.ulgi.customer.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ulgi.common.NavigationUtil;
import com.ulgi.customer.model.service.CustomerService;
import com.ulgi.customer.model.vo.Customer;


/**
 * Servlet implementation class CustomerListServlet
 */
@WebServlet("/customer/list")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cService = new CustomerService();
//		List<Customer> cList = cService.selectCustomerList();
		int totalCount = cService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
		
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<Customer> cList = cService.selectCustomerList(currentPage);
		if(cList.size() > 0) {
			
			int naviCountPerPage = 5;
			int startNavi = (currentPage-1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi -1) + naviCountPerPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("cList", cList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.getRequestDispatcher("/WEB-INF/views/customer/list.jsp")
			.forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
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
