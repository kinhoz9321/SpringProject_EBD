<%@page import="org.apache.ibatis.annotations.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#profileImage1,
	#profileImage2{
		width: 200px;
	    height: 200px;
	    border-radius: 50%;
		display:none;
	}
	#mdnavbar{
		border-top: 1px lightgrey solid;
		padding-top:0px;
	}
	/* 닉네임 프로필 사진 간격 조절 */
	.nick{
		margin-top: 16px;
		margin-bottom: 0px;
	}
	/* active 걸리는 쪽 위에 짙은 줄 효과 넣기 / 글자 굵게 하기 */
	.navbar-light .navbar-nav .active > .nav-link{
		border-top:2px solid black;
		font-weight: bold;
	}
</style>
<div class="container ">
	<div class="container text-center">
		<div class="container text-center">
			 <!-- 비어있다면 기본이미지 -->
	           <svg id="profileImage1" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
	                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
	           </svg>
			<img id="profileImage2" src="">
		</div>
		<div>
			<p style="font-size:40px;" class="nick">${sessionScope.nick }</p>
			<p style="color:grey; font-size:20px;">${sessionScope.id }</p>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm navbar-light" id="mdnavbar">
		<div class="container">
			<button class="navbar-toggler navbar-dark" data-toggle="collapse" data-target="#topNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="container collapse navbar-collapse justify-content-md-center" id="topNav">
				<ul class="navbar-nav">
					<li class="nav-item ${param.thisPage eq 'my_report' ? 'active':''}">
						<a class="nav-link" href="${pageContext.request.contextPath }/my_report/private/list.do">나의 독후감</a>
					</li>
					<li class="nav-item ${param.thisPage eq 'my_heart' ? 'active':''}">
						<a class="nav-link" href="${pageContext.request.contextPath }/my_heart/private/my_heart.do">내가 누른 하트</a>
					</li>
					<li class="nav-item ${param.thisPage eq 'my_write' ? 'active':''}">
						<a class="nav-link" href="${pageContext.request.contextPath }/my_write/private/my_write.do">내가 쓴 게시글</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<script>
	$.ajax({
           url:"${pageContext.request.contextPath}/include/mydiarynav.do",
           method:"GET",
           success:function(responsedata){
           	console.log(responsedata.profile);
           	if(responsedata.profile == null){
           		$("#profileImage1").show();
           	}else{
           		$("#profileImage2").show();
           		$("#profileImage2").attr("src","${pageContext.request.contextPath}"+responsedata.profile);
           	}
           }
       });
</script>
