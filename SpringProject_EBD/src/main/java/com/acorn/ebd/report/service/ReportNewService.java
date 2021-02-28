package com.acorn.ebd.report.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dto.ReportNewDto;

public interface ReportNewService {
	//새 독후감을 저장하는 메소드(리턴타입, 메소드명, 인자 순서) image save+db insert (insert)
	public void saveContent(ReportNewDto dto, HttpServletRequest request);
	
	//독후감 목록을 불러오는 메소드 (getList)
	public void getList(ModelAndView mView, HttpServletRequest request);
	
	//독후감 하나의 정보를 불러오는 메소드 (getDetail)
	public void getDetail(int num, ModelAndView mView);
}
