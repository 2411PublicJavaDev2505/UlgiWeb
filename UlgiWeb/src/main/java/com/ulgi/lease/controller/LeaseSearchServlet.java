package com.ulgi.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ulgi.lease.model.service.LeaseService;
import com.ulgi.lease.model.vo.Library;
import com.ulgi.lease.model.vo.Search;

/**
 * Servlet implementation class LeaseSearchServlet
 */
@WebServlet("/lease/search")
public class LeaseSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaseSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String SearchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		Search search = new Search(SearchCondition, searchKeyword);
		LeaseService lService = new LeaseService();
		
		int currentPage = request.getParameter("currentPage") != null 
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		
		List<Library> lList = lService.getSearchLeaseList(search, currentPage);
		
		int page = 5;
		int borderLimit = 10;
		
		if(lList != null) {
			int size = lService.getLeaseSearchListSize(search);
			int startNavi = (currentPage-1)/page*page + 1;
			int endNavi = startNavi+page-1;
			int maxPage = (int)Math.ceil((double)size/borderLimit) ;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("search", search);
			request.setAttribute("lList", lList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.getRequestDispatcher("/WEB-INF/views/lease/search.jsp").forward(request, response);
		}
	}
}
