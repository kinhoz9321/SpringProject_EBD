package com.acorn.ebd.report.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.ebd.report.dto.ReportDto;

@Repository
public class ReportDaoImpl implements ReportDao{
	//핵심의존객체 DI
	@Autowired
	private SqlSession session;
	
	//독후감 새 글 추가 메소드
	@Override
	public void insert(ReportDto dto) {
		session.insert("report.insert", dto);
	}
	
	
}
