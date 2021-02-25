<%@page import="org.apache.ibatis.annotations.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
1.
jsp 페이지 안에서의 주석입니다.
여기 작성한 내용은 jsp페이지가 해석하지 않습니다.
클라이언트 웹브라우저에 출력되지 않습니다. 

2.
<!---->
이것도 주석이긴 하지만 
여기 작성한 내용은 그대로 클라이언트에게 출력됩니다.
클라이언트 웹브라우저는 여기 작성한 내용을 해석하지 않습니다.

3.
nav요소는 div요소에 의미를 더한 요소이다.
-navigation 요소를 포함하고 있다고 알려준다.
-div요소라고 생각하면 편하다!

배경색이 어두운색계열이면 글자색을 밝게 navbar-dark
배경색이 밝은색 계열이면 글자색을 어둡게 navbar-light 클래스를 추가해야한다.

--%>

<%--
	특정 jsp페이지에 포함 시킬 내용을 jsp페이지에 작성할 수 있습니다.
	주의!! 부트스트랩 로딩과 js로딩은 여기서 하는 것이 아닌 이 jsp페이지를 불러간 곳에서 로딩을 해주어한다.
--%>

 
 <%--
 	// "thisPage" 라는 파라미터 명으로 전달된 문자열 읽어오기 
 	String thisPage=request.getParameter("thisPage");
 	//NullPointerException 방지 (500번 버스 안타기)
 	if(thisPage==null){
 		thisPage="";
 	}
 	
 	
 	위의 코드를 el표현으로  이렇게 고쳐쓸 수 있다. 
 	${param.thisPage eq 'cafe' ? 'active':''}
 --%>
  
 <%--fixed-top속성값을 추가해주면 상단 네비바가 고정된다. 스크롤을 올렸다 내렸다 해도 상단고정
  (단, 컨텐츠가 가려질 수 있음 navabar을 적용한 각 컨텐츠 jsp파일로 가서 padding값 줘야함(css폴더의  custom.css에서 padding값 적용시킴) --%>
 <nav class="navbar navbar-dark navbar-expand-sm fixed-top" style="background-color:#2C3E50">
	<div class="container">
		<%-- 아래 href는 최상위 경로 요청이다. 링크를 클릭하면 최상위 경로 즉, index.jsp로 이동한다. --%>
	  	<a class="navbar-brand" href="${pageContext.request.contextPath }/">
	  		<img style="width:30px;height:30px" src="${pageContext.request.contextPath }/resources/images/kim1.png"/> EveryBookDay
	  	</a>
		<%--화면을 줄이면 토글 버튼이 생긴다. data속성을 추가해 버튼을 클릭하면 사라진 링크가 뜰 수 있도록 한다.  --%>
		<%--눌렀을 때 동작을 결정하는 것은 자바스크립트가 한다. 따라서 jquery를 로딩해주어야한다.  --%>
		<button class="navbar-toggler navbar-dark" data-toggle="collapse" data-target="#topNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<%--화면을 줄였을 때  링크가 사라지며 토글버튼이 생긴다. --%>
		<div class="collapse navbar-collapse" id="topNav">
			<%-- margin-right auto 속성값을 추가하면 ul태그 아래에 있는 속성들이 화면 우측으로 이동함 --%>
			<ul class="navbar-nav mr-auto">
				<%--thisPage에 저장된 값이 "my_report"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'my_report' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/my_report/private/list.do">my_report</a>
				</li>
				<%--thisPage에 저장된 값이 "public_report"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'public_report' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/pubic_report/list.do">public_report</a>
				</li>
				<%--thisPage에 저장된 값이 "market"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'market' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/market/list.do">market</a>
				</li>
				<%--thisPage에 저장된 값이 "file"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'file' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/file/list.do">file</a>
				</li>
				<%--thisPage에 저장된 값이 "episode"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'episode' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/episode/list.do">episode</a>
				</li>
				<%--thisPage에 저장된 값이 "gallery"이면 active시켜라 포커싱된다. --%>
				<li class="nav-item ${param.thisPage eq 'wording' ? 'active':''}">
					<%--글 목록 링크를 누르면 href로 설정한 곳으로 이동(요청) --%>
					<a class="nav-link" href="${pageContext.request.contextPath }/wording/list.do">wording</a>
				</li>
			</ul>

			<c:choose>
				<%--session scope에 로그인 된 아이디가 있는지 찾아본다.--%>
				<c:when test="${empty sessionScope.id }">
					<a class="btn btn-success btn-sm" 
					href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
					<a class="btn btn-danger btn-sm ml-1" 
					href="${pageContext.request.contextPath }/users/signupform.do">회원가입</a>
					</c:when>
				<%--로그인 된 아이디가 있을 때 아이디를 클릭하면 info.do요청을 하도록 한다. --%>
				<c:otherwise>
					<span class="navbar-text">
						<a href="${pageContext.request.contextPath }/users/private/info.do">${sessionScope.id }</a>
						<a href="#">${sessionScope.nick }</a>
						<a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>
					</span>
				</c:otherwise>
			</c:choose>
	
		</div>
	</div>
</nav>     