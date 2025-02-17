package com.ulgi.book.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ulgi.book.model.vo.Book;
import com.ulgi.book.model.vo.SearchVO;

public class BookDAO {

	public List<Book> selectListAll(SqlSession session, int currentPage, String searchCondition, String searchKeyword) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("searchCondition", searchCondition);
		paraMap.put("searchKeyword", searchKeyword);
		
		List<Book> bList = session.selectList("BookMapper.selectListAll", paraMap, rowBounds);
		return bList;
	}

	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("BookMapper.getTotalCount");
	    return totalCount;
	}

	public List<Book> selectSearchList(SqlSession session, SearchVO search, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Book> searchList = session.selectList("BookMapper.selectSearchList", search, rowBounds);
		return searchList;
	}

	public Book selectOneByNo(SqlSession session, int bookNo) {
		Book book = session.selectOne("BookMapper.selectOneByNo", bookNo);
		return book;
	}

	public int deleteBook(SqlSession session, int bookNo) {
		int result = session.delete("BookMapper.deleteBook", bookNo);
		return result;
	}

	public int insertBook(SqlSession session, Book book) {
		int result = session.insert("BookMapper.insertBook", book);
		return result;
	}

	public int getSearchCount(SqlSession session, SearchVO search) {
		int result = session.selectOne("BookMapper.getSearchCount", search);
		return result;
	}

	

}
