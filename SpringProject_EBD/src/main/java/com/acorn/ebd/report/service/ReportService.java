package com.acorn.ebd.report.service;

import com.acorn.ebd.report.dto.ReportDto;

public interface ReportService {
	//새글을 저장하는 메소드(리턴타입, 메소드명, 인자 순서)
	public void saveContent(ReportDto dto);
}
