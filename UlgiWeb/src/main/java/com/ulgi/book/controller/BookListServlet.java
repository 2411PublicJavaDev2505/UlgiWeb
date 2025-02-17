package com.ulgi.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.ulgi.book.model.service.BookService;
import com.ulgi.book.model.vo.Book;
import com.ulgi.book.model.vo.SearchVO;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bService = new BookService();
		int naviCountPerPage = 5;
		int boardLimit = 10;
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		List<Book> bList = bService.selectListAll(currentPage,searchCondition,searchKeyword);
		if(bList != null) {			
			int totalCount = bService.getTotalCount();
			int startNavi = (currentPage - 1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = startNavi +naviCountPerPage-1;
			int maxPage = (int)Math.ceil((double)totalCount/boardLimit);
			if(endNavi > maxPage) {endNavi = maxPage;}
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("bList", bList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("searchKeyword", searchKeyword);
			request.setAttribute("searchCondition", searchCondition);
			request.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(request, response);
		}else { //에러페이지 이동
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}



}
