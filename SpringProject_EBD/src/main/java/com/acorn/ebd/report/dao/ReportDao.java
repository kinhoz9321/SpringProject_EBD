package com.acorn.ebd.report.dao;

import com.acorn.ebd.report.dto.ReportDto;

public interface ReportDao {
	
	//독후감 새 글 추가 메소드
	public void insert(ReportDto dto);
}
