<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/my_report/private/detail.jsp</title>
<style>
	td > img {
		height:250px;
	}
</style>
</head>
<body>
<h1>상세페이지</h1>
<div class="container">
	<table>
		<tr>
			<th></th>
			<td><img src="${pageContext.request.contextPath }${dto.imgpath }"/></td>
		</tr>
		<tr>
			<th>책제목</th>
			<td></td>
		</tr>
		<tr>
			<th>작가</th>
			<td></td>
		</tr>
			<th>장르</th>
			<td>${dto.genre }</td>
		<tr>
		</tr>
		<tr>
			<th>평점</th><!-- 별점 / 평점 수정하기 -->
			<td>${dto.stars }/5.0</td>
		</tr>
		<tr>
			<th>구매처 링크</th>
			<td></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content }</td>
		</tr>
	</table>
	<c:if test="${dto.writer eq nick }">
		<button>
			<a href="${pageContext.request.contextPath }/my_report/private/updateform.do?num=${dto.num}"/>수정</a>
		</button>
		<button>
			<a href="javascript:deleteConfirm()">삭제</a>
		</button>
	</c:if>
</div>
<script>
	function deleteConfirm(){
		var isDelete=confirm("이 글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath }/my_report/private/delete.do?num=${dto.num}";
		}
	}
</script>	
</body>
</html>