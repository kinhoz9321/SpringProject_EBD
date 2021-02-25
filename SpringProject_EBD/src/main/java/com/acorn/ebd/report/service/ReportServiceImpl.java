package com.acorn.ebd.report.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acorn.ebd.report.dao.ReportDao;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ReportDao dao;

}
