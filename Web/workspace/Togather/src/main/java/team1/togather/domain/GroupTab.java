package team1.togather.domain;

import java.sql.Date;

public class GroupTab {
	 private long gSeq;
	 private String gName;
	 private String gIntro;
	 private long mNum;
	 private String gAddr;
	 private String time;
	 private String interest;
	 private int limit;
	 private int price;
	 private Date rdate;
	 
	 public GroupTab() {}

	public GroupTab(long gSeq, String gName, String gIntro, long mNum, String gAddr, String time, String interest,
			int limit, int price, Date rdate) {
		super();
		this.gSeq = gSeq;
		this.gName = gName;
		this.gIntro = gIntro;
		this.mNum = mNum;
		this.gAddr = gAddr;
		this.time = time;
		this.interest = interest;
		this.limit = limit;
		this.price = price;
		this.rdate = rdate;
	}

	public long getgSeq() {
		return gSeq;
	}

	public void setgSeq(long gSeq) {
		this.gSeq = gSeq;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgIntro() {
		return gIntro;
	}

	public void setgIntro(String gIntro) {
		this.gIntro = gIntro;
	}

	public long getmNum() {
		return mNum;
	}

	public void setmNum(long mNum) {
		this.mNum = mNum;
	}

	public String getgAddr() {
		return gAddr;
	}

	public void setgAddr(String gAddr) {
		this.gAddr = gAddr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	 

}
