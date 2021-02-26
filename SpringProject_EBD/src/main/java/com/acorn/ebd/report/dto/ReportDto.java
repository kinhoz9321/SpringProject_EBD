package com.acorn.ebd.report.dto;

public class ReportDto {
	//필드
	private int num;
	private String writer;
	private String content;
	private int viewcnt;
	private String regdate;
	
	public ReportDto() {}

	public ReportDto(int num, String writer, String content, int viewcnt, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
