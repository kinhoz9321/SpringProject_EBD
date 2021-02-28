package com.acorn.ebd.report.dao;

import java.util.List;

import com.acorn.ebd.report.dto.ReportNewDto;

public interface ReportNewDao {
	//독후감 새글 추가 메소드
	public void insert(ReportNewDto dto);
	
	//독후감 목록 불러오기 메소드
	public List<ReportNewDto> getList(ReportNewDto dto);
	
	//독후감 상세보기 메소드
	public ReportNewDto getData(int num);
}
