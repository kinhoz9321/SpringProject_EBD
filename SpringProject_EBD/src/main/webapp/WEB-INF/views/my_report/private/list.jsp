<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/my_report/private/list.jsp</title>
</head>
<body>
<div class="container">
	<h3>마이 독후감 목록 출력하는 페이지</h3>
	<a href="${pageContext.request.contextPath }/my_report/private/insertform.do">마이독후감 새글 작성 페이지 이동</a>
	<c:forEach var="tmp" items="${requestScope.list }">
		<a href="detail.do?num=${tmp.num }">
			<div class="img-wrapper">
				<img src="${pageContext.request.contextPath }${tmp.imgpath}" /><%-- 웹브라우저가 이미지를 받아오기 위해서 이 경로로 요청하는 것 '요청' 우리가 정확한 경로 구성 --%>
			</div>
		</a>
	</c:forEach>
</div>
</body>
</html>