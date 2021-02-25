package com.acorn.ebd.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dto.ReportDto;
import com.acorn.ebd.report.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;
	
	//마이 독후감의 목록을 불러온다. list.jsp 로 이동
	@RequestMapping("/my_report/private/list")
	public ModelAndView list(ModelAndView mView, HttpServletRequest request) {
		
		return mView;
	}
	
	//마이 독후감의 새글 작성 폼을 불러온다. insertform.jsp 로 이동
	@RequestMapping("/my_report/private/insertform")
	public String insertform() {
		
		return "my_report/private/insertform";
	}
	
	//마이 독후감의 새글 작성을 저장한다. insert.jsp 로 이동
	@RequestMapping("/my_report/private/insert")
	public String insert() {
		
		return "my_report/private/insert";
	}
	
	//마이 독후감의 상세페이지를 불러온다. detail.jsp 로 이동
	@RequestMapping("/my_report/private/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		
		return mView;
	}
}
