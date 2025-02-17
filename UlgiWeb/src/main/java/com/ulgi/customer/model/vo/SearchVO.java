package com.ulgi.customer.model.vo;

public class SearchVO {
	private String searchCondition;
	private String searchKeyword;
	
	public SearchVO() {}

	public SearchVO(String searchCondition, String searchKeyword) {
		super();
		this.searchCondition = searchCondition;
		this.searchKeyword = searchKeyword;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "SearchVO [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}

	
	
}
