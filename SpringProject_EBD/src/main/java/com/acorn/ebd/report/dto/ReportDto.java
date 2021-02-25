package com.acorn.ebd.report.dto;

import org.springframework.web.multipart.MultipartFile;

public class ReportDto {
	//필드
	private int num; //글번호 - 삭제할 때 사용
	private String writer; //작성자 (users.nick) - join 연결고리
	//title, author, link는 빼야할지도 모름.
	private String title; //책제목 BookSearchDto 에서 가져오기 변수명 동일
	private String author; //작가 BookSearchDto 에서 가져오기 변수명 동일
	private String link; //구매처 링크 BookSearchDto 에서 가져오기 변수명 동일
	private String genre; //장르
	private int stars; //별점
	private String imgpath; //이미지
	private MultipartFile image; //업로드 되는 이미지의 정보를 담을 필드
	private String content; //내용
	private String publicck; //공개,비공개 여부
	private int viewcnt; //조회수
	private String regdate; //등록일
	//페이징 처리를 하기 위한 필드
	private int startRowNum; 
	private int endRowNum;
	private int prevNum; //이전 글의 글번호
	private int nextNum; //다음 글의 글번호
	
	public ReportDto() {}

	public ReportDto(int num, String writer, String title, String author, String link, String genre, int stars,
			String imgpath, MultipartFile image, String content, String publicck, int viewcnt, String regdate,
			int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.author = author;
		this.link = link;
		this.genre = genre;
		this.stars = stars;
		this.imgpath = imgpath;
		this.image = image;
		this.content = content;
		this.publicck = publicck;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublicck() {
		return publicck;
	}

	public void setPublicck(String publicck) {
		this.publicck = publicck;
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

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
	
	
}
