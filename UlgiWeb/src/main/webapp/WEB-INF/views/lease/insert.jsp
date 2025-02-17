<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>대여 추가 페이지</title>
	<link rel="stylesheet" href="../resources/css/reset.css">
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/insert.css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main>
			<p class="content-title">대여 관리 - 추가하기</p>
			<form action="/lease/insert" method="post">
				<table class="detail">
					<tr>
						<td class="lease-tbTitle">책이름</td>
						<td class="tbContent">
							<select name="bookName">
								<c:forEach items="${bList }" var="list">
									<option value="${list }">${list }</option>
								</c:forEach>
							</select>						
						</td>
					</tr>
					<tr>
						<td class="lease-tbTitle">고객아이디</td>
						<td class="tbContent">
							<select name="userId">
								<c:forEach items="${uList }" var="list">
									<option value="${list }">${list }</option>
								</c:forEach>
							</select>						
						</td>
					</tr>
				</table>
				<button class="delete-button" type="submit">추가</button>				
			</form>
		</main>
	</div>
</body>
</html>