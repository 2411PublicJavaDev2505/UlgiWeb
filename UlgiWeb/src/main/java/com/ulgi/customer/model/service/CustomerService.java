package com.ulgi.customer.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ulgi.common.SqlSessionTemplate;
import com.ulgi.customer.model.dao.CustomerDAO;
import com.ulgi.customer.model.vo.Customer;
import com.ulgi.customer.model.vo.SearchVO;

public class CustomerService {
		
	private SqlSession session;
	private CustomerDAO cDao;
	
	public CustomerService() {
		session = SqlSessionTemplate.getSqlSession();
		cDao = new CustomerDAO();
		
	}
	
	public List<Customer> selectCustomerList(int currentPage) {
		List<Customer> cList = cDao.selectCutomerList(session, currentPage);
		return cList;
	}

	public List<Customer> selectCustomerSearch(int currentPage, SearchVO searchVO) {
		List<Customer> cList = cDao.selectCustomerSearch(session, currentPage, searchVO);
		return cList;
	}

	public int getTotalCount() {
		int totalCount = cDao.getTotalCount(session);
		return totalCount;
	}

	public int insertCustomer(Customer cus) {
		return cDao.insertcustomer(session, cus);
	}

	public Customer selectOneByUserNo(int userNo) {
		return cDao.selectOneByUserNo(session, userNo);
	}

	public int deleteByNo(int userNo) {
		return cDao.deleteByNo(session, userNo);
	}

	public int getSearchListSize(SearchVO searchVO) {
		return cDao.getSearchListSize(session, searchVO);
	}

	public int updateCustomer(Customer customer) {
		return cDao.updateCustomer(session, customer);
	}

}
