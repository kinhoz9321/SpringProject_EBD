<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/my_report_new/private/list.jsp</title>
</head>
<script>
	alert("독후감이 저장 되었습니다.");
	location.href="${pageContext.request.contextPath }/my_report_new/private/list.do";
</script>
</html>