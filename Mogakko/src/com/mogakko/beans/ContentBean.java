package com.mogakko.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class ContentBean {

	private int content_idx; 
	
	@NotBlank
	private String content_subject;
	@NotBlank
	private String content_text; 
	
	//브라우저가 보낸 파일데이터는 MultipartFile이라는 객체로 만들어져서 bean에 주입하려 시도
	//브라우저가 보낸 파일데이터를 담기 위해 사용할 변수
	private MultipartFile upload_file;
	
	//db에 저장돼 있는 파일 이름을 담을 변수
	private String content_file;
	private int content_writer_idx ;	                 
    private int content_board_idx;
    private String content_date;
    private String content_writer_name;
    private String content_writer_id;
    
    //선택자- 지역선택
    private String content_location;
    
    //위도
    private double content_lat;
    //경도
    private double content_lng;
    
    public int getContent_idx() {
		return content_idx;
	}
	public void setContent_idx(int content_idx) {
		this.content_idx = content_idx;
	}
	public String getContent_subject() {
		return content_subject;
	} 
	public void setContent_subject(String content_subject) {
		this.content_subject = content_subject;
	}
	public String getContent_text() {
		return content_text;
	}
	public void setContent_text(String content_text) {
		this.content_text = content_text;
	}
	public String getContent_file() {
		return content_file;
	}
	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}
	public int getContent_writer_idx() {
		return content_writer_idx;
	}
	public void setContent_writer_idx(int content_writer_idx) {
		this.content_writer_idx = content_writer_idx;
	}
	public int getContent_board_idx() {
		return content_board_idx;
	}
	public void setContent_board_idx(int content_board_idx) {
		this.content_board_idx = content_board_idx;
	}
	public String getContent_date() {
		return content_date;
	}
	public void setContent_date(String content_date) {
		this.content_date = content_date;
	}
	public MultipartFile getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}
	public String getContent_writer_name() {
		return content_writer_name;
	}
	public void setContent_writer_name(String content_writer_name) {
		this.content_writer_name = content_writer_name;
	}
	
	
	
	
	public String getContent_writer_id() {
		return content_writer_id;
	}
	public void setContent_writer_id(String content_writer_id) {
		this.content_writer_id = content_writer_id;
	}
	public String getContent_location() {
		return content_location;
	}
	public void setContent_location(String content_location) {
		this.content_location = content_location;
	}
	public double getContent_lat() {
		return content_lat;
	}
	public void setContent_lat(double content_lat) {
		this.content_lat = content_lat;
	}
	public double getContent_lng() {
		return content_lng;
	}
	public void setContent_lng(double content_lng) {
		this.content_lng = content_lng;
	}

	
	
	
	
	
	
	
	    
}
