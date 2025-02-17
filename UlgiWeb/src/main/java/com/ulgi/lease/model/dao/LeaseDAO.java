package com.ulgi.lease.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ulgi.lease.model.vo.Library;
import com.ulgi.lease.model.vo.Search;

public class LeaseDAO {

	public List<Library> getLeaseList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("LibraryMapper.getLeaseList",null, rowBounds);
	}

	public int getLeaseListSize(SqlSession session) {
		return session.selectOne("LibraryMapper.getLeaseListSize");
	}

	public List<Library> getSearchLeaseList(SqlSession session, Search search, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("LibraryMapper.getSearchLeaseList", search, rowBounds);
	}

	public int getLeaseSearchListSize(SqlSession session, Search search) {
		return session.selectOne("LibraryMapper.getLeaseSearchListSize", search);
	}

	public Library selectOneByLeaseNo(SqlSession session, int leaseNo) {
		return session.selectOne("LibraryMapper.selectOneByLeaseNo",leaseNo);
	}

	public int deleteByLeaseNo(SqlSession session, int leaseNo) {
		return session.delete("LibraryMapper.deleteByLeaseNo",leaseNo);
	}

	public int insertLease(SqlSession session, Library library) {
		return session.insert("LibraryMapper.insertLease", library);
	}

	public int selectBookNoByName(SqlSession session, String bookName) {
		return session.selectOne("LibraryMapper.selectBookNoByName", bookName);
	}

	public List<String> selectBookNameList(SqlSession session) {
		return session.selectList("LibraryMapper.selectBookNameList");
	}

	public List<String> selectUserIdList(SqlSession session) {
		return session.selectList("LibraryMapper.selectUserIdList");
	}

}
