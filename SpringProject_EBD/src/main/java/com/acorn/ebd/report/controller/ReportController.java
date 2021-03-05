package com.acorn.ebd.report.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.booksearch.service.BookSearchService;
import com.acorn.ebd.report.dto.CafeCommentDto;
import com.acorn.ebd.report.dto.ReportDto;
import com.acorn.ebd.report.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;

	@Autowired
	private BookSearchService bservice;


	@RequestMapping("/public_report/ajax_comment_list")
	public ModelAndView ajaxCommentList(HttpServletRequest request,
			ModelAndView mView) {
		service.moreCommentList(request);
		mView.setViewName("public_report/ajax_comment_list");
		return mView;
	}
	
	//댓글 수정 ajax 요청에 대한 요청 처리
	@RequestMapping(value = "/public_report/private/comment_update",  method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commentUpdate(CafeCommentDto dto){
		//댓글을 수정 반영하고 
		service.updateComment(dto);
		//JSON 문자열을 클라이언트에게 응답한다.
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", dto.getNum());
		map.put("content", dto.getContent());
		return map;	
	}
	
	//댓글 삭제 기능
	@RequestMapping("/public_report/private/comment_delete")
	public ModelAndView commentDelete(HttpServletRequest request,
			ModelAndView mView, @RequestParam int ref_group) {
		service.deleteComment(request);
		mView.setViewName("redirect:/public_report/detail.do?num="+ref_group);//detail 페이지가 새로고침되는 효과 글로 다시 돌아오려면 글번호를 다시 들고와야함 ref_group
		return mView;
	}
	
	//새 댓글 저장 요청 처리
	@RequestMapping(value = "/public_report/private/comment_insert", method = RequestMethod.POST)
	public String commentInsert(HttpServletRequest request, @RequestParam int ref_group) {
		//새 댓글 저장하고
		service.saveComment(request);
		//글 자세히 보기로 다시 리다일렉트 이동 시킨다.
		//ref_group 은 자세히 보기 했던 글번호
		return "redirect:/public_report/detail.do?num="+ref_group;
	}
	
    //키워드가 있을때도 있고 없을때도있음 
    //있을때는 가져가고 없을때는 안가져가고 
    @RequestMapping("/my_report/private/bookList.do")
    public ModelAndView bookList(@RequestParam(required=false)String keyword){
        ModelAndView mav = new ModelAndView();
        
        if(keyword !=null)
        {
            mav.addObject("bookList",bservice.searchBook(keyword,20,1));
        }
        mav.setViewName("my_report/private/bookList");
        return mav;
    }
    
  //독후감 새글 저장 요청 처리 
  	@RequestMapping(value = "/my_report/private/insert", method=RequestMethod.POST)
  	public String insert(ReportDto dto, HttpServletRequest request) {
  		
  		service.saveContent(dto, request);
  		return "my_report/private/insert";
  	}
  	
  	/*독후감 새글 작성 폼 요청 처리
  	@RequestMapping("/my_report/private/insertform")
  	public String insertform() {
  		
  		return "my_report/private/insertform";
  	}
  	*/
  	
    //독후감 새글 작성 폼 요청 처리
    @RequestMapping("/my_report/private/insertform.do")
    public ModelAndView insertform(@RequestParam(required = false)String booktitle, String author, String link, ModelAndView mView) {
       //title이나 author이 null이면 NullPointerException이 발생한다. 
       service.replaceInfo(booktitle, author, link, mView);
       return mView;
    }

  	//마이 독후감 글 목록 요청 처리
  	@RequestMapping("/my_report/private/list")
  	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
  		service.getList(mView, request);
  		mView.setViewName("my_report/private/list");
  		return mView;
  	}
  	
  	//마이 독후감 글 하나 정보 요청 처리
  	@RequestMapping("/my_report/private/detail")
  	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
  		service.getDetail(num, mView);
  		mView.setViewName("my_report/private/detail");
  		return mView;
  	}
  	
  	//공개 독후감 글 하나 정보 요청 처리
  	@RequestMapping("/public_report/detail")
  	public ModelAndView detail_pub(@RequestParam int num, ModelAndView mView) {
  		service.getDetail(num, mView);
  		mView.setViewName("public_report/detail");
  		return mView;
  	}
  	
  	//공개 독후감 글 목록 요청 처리
  	
  	@RequestMapping("/public_report/list")
  	public ModelAndView list2(ModelAndView mView, HttpServletRequest request) {
  		service.getPublicList(mView, request);
  		mView.setViewName("public_report/list");
  		return mView;
  	}
  	
  	//독후감 삭제 요청 처리
  	@RequestMapping("/my_report/private/delete")
  	public String delete(@RequestParam int num) {
  		service.deleteContent(num);
  		return "my_report/private/delete";
  	}
  	
  	//독후감 공개 / 비공개 요청처리
  	@RequestMapping("/my_report/private/updatepublicck")
  	public String updatepublicck(ReportDto dto) {
  		service.updatepublicck(dto);
  		return "redirect:/my_report/private/detail.do?num="+dto.getNum();
  	}
  	
  //독후감 공개 / 비공개 요청처리
  	@RequestMapping(value="/public_report/updatepublicck2", method=RequestMethod.POST)
  	public String updatepublicck2(ReportDto dto) {
  		service.updatepublicck(dto);
  		return "redirect:/my_report/private/detail.do?num="+dto.getNum();
  	}
  	//.do 요청을 하고 싶을 때는 redirect 사용
  	
}
