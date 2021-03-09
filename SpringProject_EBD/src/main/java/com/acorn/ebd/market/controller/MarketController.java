package com.acorn.ebd.market.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.market.dto.MarketCmtDto;
import com.acorn.ebd.market.dto.MarketDto;
import com.acorn.ebd.market.service.MarketService;
import com.acorn.ebd.market.service.MarketServiceImpl;

@Controller
public class MarketController {
	@Autowired
	private MarketService marketService;
	// String 데이터 하나 ModelAndView 데이터를 여러개
	
	
	// 새 댓글 저장 요청 처리
	@RequestMapping(value = "/market/private/cmt_insert.do",
				method = RequestMethod.POST)
	public String cmtInsert(HttpServletRequest request,
				@RequestParam int ref_group) {
		
		//새 댓글 저장
		marketService.insertCmt(request);
		//글 자세히 보기로 리다이렉트 이동
		return "redirect:/market/detail.do?num="+ref_group; //리턴 할 위치
	}
	
	// 댓글 삭제
	@RequestMapping("/market/private/cmt_delete.do")
	public ModelAndView cmtDelete(HttpServletRequest request,
			ModelAndView mview, @RequestParam int ref_group) {
		
		marketService.deleteCmt(request);
		mview.setViewName("redirect:/market/detail.do?num="+ref_group); //리턴할위치
		return mview; 
	}
	
	// 댓글 수정 (ajax)
	@RequestMapping(value = "/market/private/cmt_update.do",
				method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> cmtUpdate(MarketCmtDto dto){
		
		marketService.updateCmt(dto);
		// JSON문자열을 클라이언트에게 응답한다
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", dto.getNum());
		map.put("content", dto.getContent());
		return map;
		
	}
	
	// 추가 댓글 목록 (ajax)
	@RequestMapping("/market/ajax_cmt_list")
	public ModelAndView ajaxCmtList(HttpServletRequest request, 
				ModelAndView mview) {
		
		marketService.moreCmtList(request);
		mview.setViewName("cafe/ajax_cmt_list");
		return mview;
	}
	
	// 마켓 글 전체 목록 
	@RequestMapping("/market/list")
	public ModelAndView getList(HttpServletRequest request, ModelAndView mview) {
		
		marketService.getList(request);
		mview.setViewName("market/list");
		return mview;
	}
	
	// 마켓 글 디테일 
	@RequestMapping("/market/detail")
	public ModelAndView getDetail(HttpServletRequest request, ModelAndView mview, int num) {
		
		marketService.getDetail(mview, num);
		mview.setViewName("market/detail");
		return mview;
	}
	
	// 마켓 글쓰기 폼
	@RequestMapping("/market/private/insertform")
	public ModelAndView inserform(ModelAndView mview) {
		
		mview.setViewName("market/private/insertform");
		return mview;
	}
	
	// 마켓 글쓰기 요청 처리 
	@RequestMapping(value = "/market/private/insert" , method = RequestMethod.POST)
	public ModelAndView insert(ModelAndView mview, HttpServletRequest request, 
							MarketDto dto) {
		
		marketService.insert(request, dto);
		mview.setViewName("market/private/insert");
		return mview;
	}
	
	// 마켓 글쓰기 수정 폼
	@RequestMapping("/market/private/updateform")
	public ModelAndView updateform(ModelAndView mview, @RequestParam int num) {
		// num번의 데이터를 가지고 와야하니까
		marketService.getDetail(mview, num);
		mview.setViewName("market/private/updateform");
		return mview;
	}
	
	// 마켓 글쓰기 수정
	@RequestMapping(value= "/market/private/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("dto") MarketDto dto) {
		
		marketService.update(dto);
		return "market/private/update";
	}
	
	@RequestMapping("/market/private/updateStatus")
	public String updateStatus(@ModelAttribute("dto") MarketDto dto) {
		
		// 디테일페이지에서 판매상태 수정하기
		marketService.updateStatus(dto);
		return "market/private/updateStatus";
	}
	
	@RequestMapping("/market/private/delete")
	public String delete(@RequestParam int num) {
		
		return "market/private/delete";
	}
}
