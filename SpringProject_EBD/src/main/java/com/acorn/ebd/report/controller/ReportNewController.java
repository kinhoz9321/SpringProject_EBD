package com.acorn.ebd.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dto.ReportNewDto;
import com.acorn.ebd.report.service.ReportNewService;

@Controller
public class ReportNewController {
	//의존객체 DI
	@Autowired
	private ReportNewService service;
	//마이 독후감 글 목록 요청 처리
	@RequestMapping("/my_report_new/private/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		service.getList(mView, request);
		mView.setViewName("my_report_new/private/list");
		return mView;
	}
	
	//독후감 새글 작성 폼 요청 처리
	@RequestMapping("/my_report_new/private/insertform")
	public String insertform() {
		
		return "my_report_new/private/insertform";
	}
	
	//독후감 새글 저장 요청처리
	@RequestMapping(value = "/my_report_new/private/insert", method = RequestMethod.POST)
	public String insert(ReportNewDto dto, HttpServletRequest request) {
		
		service.saveContent(dto, request);
		return "my_report_new/private/insert";
	}
	
	//독후감 글 하나의 정보 요청 처리
	@RequestMapping("/my_report_new/private/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("my_report_new/private/detail");
		return mView;
	}
}
