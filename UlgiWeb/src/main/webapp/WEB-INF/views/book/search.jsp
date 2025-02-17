<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>을지도서관 - 도서 목록</title>
		<link rel="stylesheet" href="../resources/css/reset.css">
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/list.css">
	</head>
	<body>
		<div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<main id="main">
				<section class="title">
					<h1>조회 목록</h1>
				</section>
				<div class="content">
					<div class="menu">
						<div class="insert">
							<form action="/book/insert">
								<button>추가</button>
							</form>
						</div>
					</div>
					<form action="/book/search" method="get">
						<div class="search">
							<div class="select">
								<select name="searchCondition">
									<option value="code" <c:if test="${searchCondition eq 'code' }">selected</c:if>>책번호</option>
									<option value="title"<c:if test="${searchCondition eq 'title' }">selected</c:if>>책제목</option>
									<option value="writer"<c:if test="${searchCondition eq 'writer' }">selected</c:if>>작가명</option>
								</select>
							</div>
							<div class="input">
								<input type="text" class="input" name="searchKeyword" value="${searchKeyword }" placeholder="검색어를 입력하세요">
							</div>
							<div class="searchbtn">
								<button type="submit">검색</button>
							</div>
						</div>
					</form>
				</div>
				<section class="list">
					<table>
						<thead>
							<tr>
								<th class="table listno">번호</th>
								<th class="table leaseno">책번호</th>
								<th class="table bookno">제목</th>
								<th class="table writer">글쓴이</th>
								<th class="table price">가격</th>
								<th class="table publisher">출판사</th>
								<th class="table genre">장르</th>
						</thead>
						<tbody>
							<c:forEach items="${searchList }" var="book" varStatus="i">
								<tr>
									<td class="table listno">${searchList.size() - i.index }</td>
									<td class="table leaseno">${book.bookNo }</td>
									<td class="table bookno"><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</a></td>
									<td class="table writer">${book.bookWriter }</td>
									<td class="table price">${book.bookPrice }</td>
									<td class="table publisher">${book.publisher }</td>
									<td class="table genre">${book.genre }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<div class="pagination">
					<c:if test="${startNavi ne 1 }">
						<a href="/book/search?currentPage=${startNavi-1 }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}" class="prev">&lt;</a>
					</c:if>
					<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
						<a href="/book/search?currentPage=${p }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}">${p }</a>
					</c:forEach>
					<c:if test="${endNavi ne maxPage }">
						<a href="/book/search?currentPage=${endNavi+1 }&searchCondition=${search.searchCondition}&searchKeyword=${search.searchKeyword}" class="next">&gt;</a>
					</c:if>
				</div>
				</section>
			</main>
		</div>
	</body>
</html>