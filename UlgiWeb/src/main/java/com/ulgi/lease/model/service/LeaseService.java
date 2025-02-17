package com.ulgi.lease.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ulgi.common.SqlSessionTemplate;
import com.ulgi.lease.model.dao.LeaseDAO;
import com.ulgi.lease.model.vo.Library;
import com.ulgi.lease.model.vo.Search;

public class LeaseService {
	
	private LeaseDAO lDao;
	private SqlSession session;
	
	public LeaseService() {
		lDao = new LeaseDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public List<Library> getLeaseList(int currentPage) {
		return lDao.getLeaseList(session, currentPage);
	}

	public int getLeaseListSize() {
		return lDao.getLeaseListSize(session);
	}

	public List<Library> getSearchLeaseList(Search search, int currentPage) {
		return lDao.getSearchLeaseList(session, search, currentPage);
	}

	public int getLeaseSearchListSize(Search search) {
		return lDao.getLeaseSearchListSize(session, search);
	}

	public Library selectOneByLeaseNo(int leaseNo) {
		return lDao.selectOneByLeaseNo(session, leaseNo);
	}

	public int deleteByLeaseNo(int leaseNo) {
		return lDao.deleteByLeaseNo(session, leaseNo);
	}

	public int insertLease(Library library) {
		return lDao.insertLease(session, library);
	}

	public int selectBookNoByName(String bookName) {
		return lDao.selectBookNoByName(session, bookName);
	}

	public List<String> selectBookNameList() {
		return lDao.selectBookNameList(session);
	}

	public List<String> selectUserIdList() {
		return lDao.selectUserIdList(session);
	}

}
