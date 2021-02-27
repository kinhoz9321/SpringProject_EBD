package com.acorn.ebd.report.dao;

import java.util.List;

import com.acorn.ebd.report.dto.ReportDto;

public interface ReportDao {
	
	//독후감 새 글 추가 메소드
	public void insert(ReportDto dto);
	
	//독후감 목록 불러오기 
	public List<ReportDto> getList(ReportDto dto);
	
	//독후감 하나의 정보 얻어오기
	public ReportDto getData(int num);
	
	//독후감 삭제하기
	public void delete(int num);
}
