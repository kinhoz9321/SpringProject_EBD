package com.acorn.ebd.report.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements ReportDao{
	@Autowired
	private SqlSession session;
	
	
}
