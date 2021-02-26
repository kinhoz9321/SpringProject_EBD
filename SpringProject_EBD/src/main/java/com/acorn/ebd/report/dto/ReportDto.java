package com.acorn.ebd.report.dto;

import org.springframework.web.multipart.MultipartFile;

public class ReportDto {
	//필드
	private int num;
	private String writer;
	private String content;
	private int viewcnt;
	private String regdate;
	private String genre;
	private String stars;
	private String imgpath;
	private MultipartFile image;
	
	public ReportDto() {}

	public ReportDto(int num, String writer, String content, int viewcnt, String regdate, String genre, String stars,
			String imgpath) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.genre = genre;
		this.stars = stars;
		this.imgpath = imgpath;
	}

	public ReportDto(int num, String writer, String content, int viewcnt, String regdate, String genre, String stars,
			String imgpath, MultipartFile image) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.genre = genre;
		this.stars = stars;
		this.imgpath = imgpath;
		this.image = image;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	

}
