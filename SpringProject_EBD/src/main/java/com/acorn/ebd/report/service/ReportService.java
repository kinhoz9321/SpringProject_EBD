package com.acorn.ebd.report.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dto.CafeCommentDto;
import com.acorn.ebd.report.dto.ReportDto;

public interface ReportService {
	
	public void replaceInfo(String booktitle, String author, String link, ModelAndView mView);
	
	//새 독후감을 저장하는 메소드
	public void saveContent(ReportDto dto, HttpServletRequest request);
	
	//독후감을 불러오는 메소드
	public void getList(ModelAndView mView, HttpServletRequest request);
	
	//독후감 하나의 정보를 불러오는 메소드
	public void getDetail(int num, ModelAndView mView);
	
	//독후감을 삭제하는 메소드
	public void deleteContent(int num);
	
	//독후감 공개/비공개 여부를 결정하는 메소드
	public void updatepublicck(ReportDto dto);
	
	//공개 독후감 목록을 불러오는 메소드
	public void getPublicList(ModelAndView mView, HttpServletRequest request);
	//댓글을 저장하는 메소드
	public void saveComment(HttpServletRequest request);
	public void deleteComment(HttpServletRequest request);//댓글 삭제
	public void updateComment(CafeCommentDto dto);//댓글 수정
	public void moreCommentList(HttpServletRequest request);//댓글 추가 응답
}
