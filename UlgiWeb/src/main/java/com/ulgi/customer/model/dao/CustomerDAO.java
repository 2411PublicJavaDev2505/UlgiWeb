package com.ulgi.customer.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ulgi.customer.model.vo.Customer;
import com.ulgi.customer.model.vo.SearchVO;

public class CustomerDAO {

//	public List<Customer> selectCustomerList(SqlSession session, int currentPage) {
//		int limit = 10;
//		int offset = (currentPage-1)*limit;
//		RowBounds rowBounds = new RowBounds(offset, limit);
//		List<Customer> cList = session.selectList("CutomerMapper.selectCustomerList", null, rowBounds);
//		return cList;
//	}

//	public List<Customer> selectList(SqlSession session) {
//		List<Customer> searchList = session.selectList("CutomerMapper.selectList", search);
//		return searchList;
//	}



	public List<Customer> selectCutomerList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Customer> cList = session.selectList("CutomerMapper.selectCustomerList", null, rowBounds);
		return cList;
	}

	public List<Customer> selectCustomerSearch(SqlSession session, int currentPage, SearchVO searchVO) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
//		if(searchVO.getSearchCondition().equals("userNo"))
		
		List<Customer> cList = session.selectList("CutomerMapper.selectCustomerSearch", searchVO, rowBounds);
		return cList;
	}

	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("CutomerMapper.getTotalCount");
		return totalCount;
	}

	public int insertcustomer(SqlSession session, Customer cus) {
		return session.insert("CutomerMapper.insertcustomer", cus);
	}

	public Customer selectOneByUserNo(SqlSession session, int userNo) {
		return session.selectOne("CutomerMapper.selectOneByUserNo", userNo);
	}

	public int deleteByNo(SqlSession session, int userNo) {
		return session.delete("CutomerMapper.deleteByNo",userNo);
	}

	public int getSearchListSize(SqlSession session, SearchVO searchVO) {
		return session.selectOne("CutomerMapper.getSearchListSize", searchVO);
	}

	public int updateCustomer(SqlSession session, Customer customer) {
		return session.update("CutomerMapper.updateCustomer",customer);
	}

}
