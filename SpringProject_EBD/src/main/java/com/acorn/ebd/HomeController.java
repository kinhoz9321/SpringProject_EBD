package com.acorn.ebd;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.booksearch.service.BookSearchService;
import com.acorn.ebd.episode.service.EpisodeService;
import com.acorn.ebd.file.service.FileService;
import com.acorn.ebd.market.service.MarketService;
import com.acorn.ebd.report.service.ReportService;
import com.acorn.ebd.users.dto.UsersDto;
import com.acorn.ebd.users.service.UsersService;
import com.acorn.ebd.wording.service.WordingService;
@Controller
public class HomeController {
	@Autowired
	private UsersService users_service;
	
	@Autowired
	private EpisodeService episode_service;
	
	@Autowired
	private FileService file_service;
	
	@Autowired
	private MarketService market_service;
	
	@Autowired
	private ReportService report_service;
	
	@Autowired
	private WordingService wording_service;
	
	@Autowired
	private BookSearchService bservice;
	
	
	//메인화면 요청처리
	@RequestMapping("/home.do")
	public ModelAndView home(ModelAndView mView, HttpServletRequest request) {
		wording_service.getBestHeartList(mView); //좋아요 높은 순 Best3 (wordingBestList[0~3])
		report_service.getBestHeartList(mView); //좋아요 높은 순 Best3 (reportBestList[0~3])
		episode_service.getBestViewCntList(mView); //조회수 높은 순 Best3 (episodeBestList[0~3])
		file_service.getBestViewCntList(mView); //조회수 높은 순 Best3 (fileBestList[0~5])
		market_service.getList(request); //최신매물 Top3 (marketService의 getList를 재사용함)		

		
		mView.setViewName("home");
		return mView;
	}
	
	//mydiarynavbar에 이미지 프로필 불러오는 요청 처리
	@RequestMapping("/include/mydiarynav.do")
    @ResponseBody
    public Map<String, Object> getinfomy(HttpSession session) {
		UsersDto dto=users_service.getInfomy(session);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("profile",dto.getProfile());
		return map;
    }
	
	//main jumbotron에서 more버튼 클릭 시 info.jsp 이동 요청 처리
	@RequestMapping("/info.do")
	public String info() {
		return "info";
	}
	
	//mydiary 내가누른 하트 요청처리 (내가 하트 누른 독후감으로 가도록 한다.)
	@RequestMapping("/my_heart/private/my_heart.do")
	public ModelAndView myHeart(ModelAndView mView, HttpServletRequest request) {
		report_service.getMyHeartList(mView, request);
		mView.setViewName("my_heart/private/report_list");
		return mView;
		
	}
	
	//mydiary 내가 누른 하트 카테고리별 요청
	@RequestMapping("/my_heart/private/my_heart_category.do")
	public ModelAndView myHeartList(String condition, ModelAndView mView, HttpServletRequest request) {
		//condition에 따라 요청 정보를 다르게 
		if(condition.equals("report")) {
			report_service.getMyHeartList(mView, request);
			mView.setViewName("my_heart/private/report_list");
		}else if(condition.equals("market")) {
			market_service.getMyHeartList(mView, request);
			mView.setViewName("my_heart/private/market_list");
		}else if(condition.equals("file")) {
			file_service.getMyHeartList(mView, request);
			mView.setViewName("my_heart/private/file_list");
		}else if(condition.equals("episode")) {
			episode_service.getMyHeartList(mView, request);
			mView.setViewName("my_heart/private/episode_list");
		}else if(condition.equals("wording")) {
			wording_service.getMyHeartList(mView, request);
			mView.setViewName("my_heart/private/wording_list");			
		}
		return mView;
			
	}
	
	//mydiary 내가 쓴 글 클릭 요청(내가 작성한 명언/글귀로 간다)
	@RequestMapping("/my_write/private/my_write.do")
	public ModelAndView myWrite(ModelAndView mView, HttpServletRequest request) {
		wording_service.getMyWriteList(mView, request);
		mView.setViewName("my_write/private/wording_list");
		return mView;
	}
	
	//mydiary 내가 쓴 글 카테고리별 요청
	@RequestMapping("/my_write/private/my_write_category.do")
	public ModelAndView myWriteList(String condition, ModelAndView mView, HttpServletRequest request) {
		//condition에 따라 요청을 다르게 한다. 
		if(condition.equals("market")) { 
			market_service.getMyWriteList(mView, request);
			mView.setViewName("my_write/private/market_list");
		}else if(condition.equals("file")) {
			file_service.getMyWriteList(mView, request);
			mView.setViewName("my_write/private/file_list");
		}else if(condition.equals("episode")) {
			episode_service.getMyWriteList(mView, request);
			mView.setViewName("my_write/private/episode_list");
		}else if(condition.equals("wording")) {
			wording_service.getMyWriteList(mView, request);
			mView.setViewName("my_write/private/wording_list");
		}
		return mView;
			
	}
	
	//wording ajax요청처리(내가쓴글)
	@RequestMapping("/my_write/private/wording_ajax_page.do")
	public ModelAndView ajaxPage(ModelAndView mView, HttpServletRequest request) {
		wording_service.getMyWriteList(mView, request);
		mView.setViewName("my_write/private/wording_ajax_page");
		return mView;
	}
	
	//wording ajax요청처리(내가 누른 하트)
	@RequestMapping("/my_heart/private/wording_ajax_page.do")
	public ModelAndView ajaxPage2(ModelAndView mView, HttpServletRequest request) {
		wording_service.getMyHeartList(mView, request);
		mView.setViewName("my_heart/private/wording_ajax_page");
		return mView;
	}
	
	//메인화면에서 bookList.do요청
//	@RequestMapping("/bookList.do")
//	public ModelAndView bookList(String search, ModelAndView mView) {
//		mView.addObject("search");
//		mView.setViewName("bookList");
//		return mView;
//	}
	
	//메인화면에서 bookList.do요청
	//required=false는 폼에서 넘어오는 값이 없을때에도 오류를 일으키지 않는다.
	//네이버 도서검색 api의 검색 결과 요청을 처리한다. 
    @RequestMapping("/bookList.do")
    public ModelAndView bookList(@RequestParam(required = false) String keyword){
        ModelAndView mav = new ModelAndView();
        
        if(keyword !=null)
        {
            mav.addObject("bookList",bservice.searchBook(keyword,20,1));
        }
        mav.addObject("keyword",keyword);
        mav.setViewName("bookList");
        return mav;
    }
	
	// 카카오 지도 API 요청
   @RequestMapping("/map.do")
   public String map() {
      return "map";
   }
	
}