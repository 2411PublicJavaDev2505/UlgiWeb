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
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/book/search")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bService = new BookService();
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		SearchVO search = new SearchVO(searchCondition, searchKeyword);
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<Book> searchList = bService.selectSearchList(search, currentPage);
		
		int naviCountPerPage = 5;
		int boardLimit = 10;
		if(searchList != null && !searchList.isEmpty()) {
			int searchCount = bService.getSearchCount(search);
			int maxPage = (int)Math.ceil((double)searchCount/boardLimit);
			int startNavi = (currentPage - 1)/naviCountPerPage*naviCountPerPage+1;
			int endNavi = (startNavi -1) +naviCountPerPage;
			if(endNavi > maxPage) {endNavi = maxPage;}
			
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("search", search);
			request.setAttribute("searchList", searchList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
//			request.setAttribute("searchCondition", searchCondition);
//			request.setAttribute("searchKeyword", searchKeyword);
			
			request.getRequestDispatcher("/WEB-INF/views/book/search.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response); //에러페이지 이동
		}
	}

}
