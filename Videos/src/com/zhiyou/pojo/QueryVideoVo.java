package com.zhiyou.pojo;

public class QueryVideoVo {
	
	private String title;
	private String spearkerId;
	private String courseId;
	
	private int page=1;
	private int rows=10;
	private int start =0;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpearkerId() {
		return spearkerId;
	}
	public void setSpearkerId(String spearkerId) {
		this.spearkerId = spearkerId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	

}
