package com.ulgi.book.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ulgi.book.model.dao.BookDAO;
import com.ulgi.book.model.vo.Book;
import com.ulgi.book.model.vo.SearchVO;
import com.ulgi.common.SqlSessionTemplate;

public class BookService {
	
	private BookDAO bDao;
	private SqlSession session;

	public BookService() {
		bDao = new BookDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public int getTotalCount() {
		int totalCount = bDao.getTotalCount(session);
		return totalCount;
	}

	public List<Book> selectListAll(int currentPage, String searchCondition, String searchKeyword) {
		List<Book> bList = bDao.selectListAll(session, currentPage,searchCondition ,searchKeyword);
		return bList;
	}

	public List<Book> selectSearchList(SearchVO search, int currentPage) {
		List<Book> searchList = bDao.selectSearchList(session, search, currentPage);
		return searchList;
	}

	public Book selectOneByNo(int bookNo) {
		Book book = bDao.selectOneByNo(session, bookNo);
		return book;
	}

	public int deleteBook(int bookNo) {
		int result = bDao.deleteBook(session, bookNo);
		return result;
	}

	public int insertBook(Book book) {
		int result = bDao.insertBook(session, book);
		return result;
	}

	public int getSearchCount(SearchVO search) {
		int result = bDao.getSearchCount(session, search);
		return result;
	}

}
