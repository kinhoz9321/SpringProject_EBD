package com.acorn.ebd.report.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.ebd.report.dto.ReportNewDto;

@Repository
public class ReportNewDaoImpl implements ReportNewDao{
	@Autowired
	private SqlSession session;

	@Override
	public void insert(ReportNewDto dto) {
		
		session.insert("reportnew.insert", dto);
	}

	@Override
	public List<ReportNewDto> getList(ReportNewDto dto) {
		
		return session.selectList("reportnew.getList", dto);
	}

	@Override
	public ReportNewDto getData(int num) {

		return session.selectOne("reportnew.getData", num);
	}

}
