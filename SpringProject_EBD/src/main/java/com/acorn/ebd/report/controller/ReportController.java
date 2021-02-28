package com.acorn.ebd.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dto.ReportDto;
import com.acorn.ebd.report.service.ReportService;

@Controller
public class ReportController {
	//의존객체 DI
	@Autowired
	private ReportService service;
	
	//독후감 새글 저장 요청 처리 
	@RequestMapping(value = "/my_report/private/insert", method=RequestMethod.POST)
	public String insert(ReportDto dto, HttpServletRequest request) {
		
		service.saveContent(dto, request);
		return "my_report/private/insert";
	}
	
	//독후감 새글 작성 폼 요청 처리
	@RequestMapping("/my_report/private/insertform")
	public String insertform() {
		
		return "my_report/private/insertform";
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
	
	//독후감 삭제 요청 처리
	@RequestMapping("/my_report/private/delete")
	public String delete(@RequestParam int num) {
		service.deleteContent(num);
		return "my_report/private/delete";
	}
	
	//독후감 수정 폼 요청 처리
	@RequestMapping("/my_report/private/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("my_report/private/updateform");
		return mView;
	}
}
