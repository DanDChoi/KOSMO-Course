package team1.togather.domain;

public class Gathering {
	private long gt_seq;
	private String gt_name;
	private String gt_date;
	private String time;
	private String gt_place;
	private String price;
	private int gt_limit;
	private long gSeq;
	
	public Gathering(long gt_seq, String gt_name, String gt_date, String time, String gt_place, String price,
			int gt_limit, long gSeq) {
		super();
		this.gt_seq = gt_seq;
		this.gt_name = gt_name;
		this.gt_date = gt_date;
		this.time = time;
		this.gt_place = gt_place;
		this.price = price;
		this.gt_limit = gt_limit;
		this.gSeq = gSeq;
	}
	
	public long getGt_seq() {
		return gt_seq;
	}
	public void setGt_seq(long gt_seq) {
		this.gt_seq = gt_seq;
	}
	public String getGt_name() {
		return gt_name;
	}
	public void setGt_name(String gt_name) {
		this.gt_name = gt_name;
	}
	public String getGt_date() {
		return gt_date;
	}
	public void setGt_date(String gt_date) {
		this.gt_date = gt_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGt_place() {
		return gt_place;
	}
	public void setGt_place(String gt_place) {
		this.gt_place = gt_place;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getGt_limit() {
		return gt_limit;
	}
	public void setGt_limit(int gt_limit) {
		this.gt_limit = gt_limit;
	}
	public long getgSeq() {
		return gSeq;
	}
	public void setgSeq(long gSeq) {
		this.gSeq = gSeq;
	}
	
}
