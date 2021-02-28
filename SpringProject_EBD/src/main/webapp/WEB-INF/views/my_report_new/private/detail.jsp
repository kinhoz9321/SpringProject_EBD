<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/my_report_new/private/detail.jsp</title>
<jsp:include page="../../include/resource.jsp"></jsp:include>
<style>
	img{
		width:500px;
	}
</style>
</head>
<body>
<div class="container">
	<table class="table">
		<tr>
			<th>조회수</th>
			<td>${dto.viewcnt }</td>
			<th>날짜</th>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<th></th>
			<td><img src="${pageContext.request.contextPath }${dto.imgpath }" alt="" /></td>
		</tr>
		<tr>
			<th>도서명</th>
			<td>${dto.booktitle }</td>
		</tr>
		<tr>
			<th>저자명</th>
			<td>${dto.author }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>장르</th>
			<td>${dto.genre }</td>
		</tr>
		<tr>
			<th>평점</th>
			<td>${dto.stars }</td>
		</tr>
		<tr>
			<th>구매처 링크</th>
			<td>${dto.link }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content }</td>
		</tr>
	</table>
	<button>
		<a href="${pageContext.request.contextPath }/my_report_new/private/updateform.do?num=${dto.num}"/>수정</a>
	</button>
	<button>
		<a href="javascript:deleteConfirm()">삭제</a>
	</button>
</div>
<script>
	function deleteConfirm(){
		var isDelete=confirm("이 글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath }/my_report_new/private/delete.do?num=${dto.num}";
		}
	}
</script>	
</body>
</html>