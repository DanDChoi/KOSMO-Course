package dan.md.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardListResult {
	private List<Board> list;
	private int cp;
	private int ps;
	private long totalCount;
	private long totalPageCount;
	
	public BoardListResult(int cp, int ps, long totalCount, List<Board> list) { //순서는 상관없음
		this.cp = cp;
		this.ps = ps;
		this.totalCount = totalCount;
		this.list = list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc = totalCount/ps;
		if(totalCount%ps != 0) tpc++;
		return tpc;
	}
}
