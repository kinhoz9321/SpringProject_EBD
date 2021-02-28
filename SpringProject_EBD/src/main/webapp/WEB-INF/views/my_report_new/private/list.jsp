<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/my_report_new/private/list.jsp</title>
<jsp:include page="../../include/resource.jsp"></jsp:include>
<style>
	img{
		height:250px;
	}
</style>
</head>
<body>
<a href="${pageContext.request.contextPath }/my_report_new/private/insertform.do">새글 작성하러 가기</a>
<div class="container">
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