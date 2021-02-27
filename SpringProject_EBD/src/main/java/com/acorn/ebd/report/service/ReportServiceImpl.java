package com.acorn.ebd.report.service;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.ebd.report.dao.ReportDao;
import com.acorn.ebd.report.dto.ReportDto;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public void saveContent(ReportDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값 얻어오기 
		MultipartFile myFile=dto.getImage();
		//원본 파일명
		String orgFileName=myFile.getOriginalFilename();
		
		// webapp/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath=request.getServletContext().getRealPath("/upload");
		//저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload=new File(filePath);
		if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
			upload.mkdir(); //만들어 준다.
		}
		//저장할 파일 명을 구성한다. (겹치는 파일명이 없도록 한다)
		String saveFileName=
				System.currentTimeMillis()+orgFileName;
		try {
			//upload 폴더에 파일을 저장한다.
			myFile.transferTo(new File(filePath+saveFileName));
			System.out.println(filePath+saveFileName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//dto에 업로드 된 파일의 정보 담기
		String writer=(String)request.getSession().getAttribute("nick");//나중에 nick 으로 받기?
		dto.setWriter(writer);
		dto.setImgpath("/upload/"+saveFileName);
		//ReportDao 를 이용해서 DB에 저장하기
		reportDao.insert(dto);
	}

	@Override
	public void getList(ModelAndView mView, HttpServletRequest request) {
		ReportDto dto=new ReportDto();
		List<ReportDto> list=reportDao.getList(dto);
		mView.addObject("list", list);
		
	}

	@Override
	public void getDetail(int num, ModelAndView mView) {
		ReportDto dto=reportDao.getData(num);
		mView.addObject("dto", dto);
		
	}

	@Override
	public void deleteContent(int num) {
		reportDao.delete(num);
		
	}
	
}
