package com.acorn.ebd.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//web.xml 필터 설정 대신에 annotation 을 활용해서 필터를 동작하게 할수도 있다. 
//urlpatterns라는 이름의 배열을 생성한다. 각 배열의 요소로 적용할 경로를 적어준다. 
///users/private 하위 폴더에 있는 모든 파일에 대해 필터를 적용한다.
///cafe/private하위 폴더에 있는 모든 파일에 대해 필터를 적용한다.
@WebFilter(urlPatterns = {"/users/private/*","/my_report_new/private/*","/public_report/private/*","/market/private/*","/file/private/*","/episode/private/*","/wording/private/*"})
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter Filter doFilter() 동작중...");
		//1. 로그인 된 클라이언트인지 확인한다.(request)
		HttpServletRequest req=(HttpServletRequest)request;
		//자식 type을 이용해서 HttpSession 객체의 참조값을 얻어낸다.
		HttpSession session=req.getSession();
		//로그인 된 아이디가 있는지 읽어와 본다.
		String id=(String)session.getAttribute("id");
		//만일 로그인 된 상태라면
		if(id!=null) {
			//2. 만일 로그인을 했으면 관여하지 않고 요청의 흐름을 이어간다.(chain)
			chain.doFilter(request, response);
		}else {
			/*
			 	로그인 페이지로 강제 리다이렉트 됐다면
			 	로그인 성공 후에 원래 가려던 목적지로 다시 보내야 하고
			 	GET방식 전송 파라미터가 있다면 파라미터 정보도 같이 가지고 갈 수 있도록 해야한다.
			 	ex) 업로드 하려고 하는데 로그인을 안해서 로그인창으로 이동됐는데 로그인했더니 업로드 창으로 안가고
			 	인덱스창으로 가는 현상!! 로그인을 했을 때 업로드창으로 가도록 해보자. 
			 	여기서 원래 목적지 : 업로드창
			 	로그인필터에서 login_form으로 encodedUrl로 GET방식 전송을 하고
			 	login_form.jsp에서 getParameter로 값을 받은 후
			 	그 값을 또 login.jsp에서 받아서 해결해보자. 
			*/
			//원래 가려던 url 정보 읽어오기
			String url=req.getRequestURI();
			//GET방식 전송 파라미터를 query 문자열로 읽어오기 (주소창에 a=xxxx&b=xxx&c=xxx.. 형태로 생긴 것을 query문이라 한다.)
			String query=req.getQueryString();
			//특수 문자는 인코딩을 해야한다.
			String encodedUrl=null;
			if(query==null) {//전송 파라미터가 없다면 쿼리문 없이 간다. 
				encodedUrl=URLEncoder.encode(url);
			}else {//전송 파라미터가 있다면 쿼리문을 달고 간다. 
				//원래 목적지가 /test/xxx.jsp라고 가정하면 아래와 같은 형식의 문자열을 만든다.
				//"/test/xxx.jsp?a=xxx&b=xxx..."
				encodedUrl=URLEncoder.encode(url+"?"+query);
			}
			//3. 로그인을 하지 않았으면 로그인 폼으로 이동할 수 있도록 리다이렉트 응답을 준다.(response)
			String cPath=req.getContextPath();
			//HttpServlet는 자식타입, ServletResponse는 부모타입
			//sendRedirect() 메소드 역시 HttpServlet객체로 사용가능!
			//다운캐스팅 해준다.
			HttpServletResponse res=(HttpServletResponse)response;
			//sendRedirect()의 인자로 적어준 경로로 가라고 요청한다. 이를 redirect 응답이라고 한다. 
			//redirect응답은 요청을 다시하라는 응답이다. 어디로 요청? sendRedirect의 인자로 적어준 경로로 요청
			//또한 리다이렉트 시킬 때 원래 목적지 정보를 url이라는 파라미터 명으로 같이 보낸다.
			res.sendRedirect(cPath+"/users/loginform.do?url="+encodedUrl);
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
