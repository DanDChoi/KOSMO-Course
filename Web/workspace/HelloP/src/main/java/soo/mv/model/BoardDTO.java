package soo.mv.model;

import java.sql.Date;

public class BoardDTO {
	private int seq;
	private String name;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	
	//(1) Constructor Á¤ÀÇ
	public BoardDTO() {
		super();
	}
	public BoardDTO(int seq, String name, String email, String subject, String content, Date rdate) {
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.rdate = rdate;
	}
	
	//(2) Setter
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void seName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setRDate(Date rdate) {
		this.rdate = rdate;
	}
	
	//(3) Getter
	public int getSeq() {
		return seq;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public Date getRdate() {
		return rdate;
	}
}
