package mvc.domain;

import java.sql.Date;

public class Board {
	private long bseq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	
	public Board() {}
	public Board(long bseq, String writer, String email, String subject, String content, Date rdate) {
		this.bseq = bseq;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.rdate = rdate;
	}
	public long getBseq() {
		return bseq;
	}
	public void setBseq(long bseq) {
		this.bseq = bseq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
}
