<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/private/delete.jsp</title>
</head>
<body>
<!-- 독후감 양식 파일(게시글) 삭제 -->
<script>
	alert("게시글이 삭제 되었습니다.");
	location.href="${pageContext.request.contextPath}/file/list.do";
</script>
</body>
</html>