package com.ulgi.lease.model.vo;

public class Search {
	private String searchCondition;
	private String searchKeyword;
	
	public Search() {}
	
	public Search(String searchCondition, String searchKeyword) {
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

	@Override
	public String toString() {
		return "Search [searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}
}
