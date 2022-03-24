package dan.md.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import dan.md.domain.Board;
import dan.md.domain.BoardVo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardListResult {
	private List<Board> list;
	private int cp;
	private int ps;
	private long totalCount;
	private long totalPageCount;  // <-때문에 모든 파라미터를 넣어서 생성자를 만드는것은 안좋음
	
	public BoardListResult(int cp, long totalCount, int ps, List<Board> list) {
		this.cp = cp;
		this.totalCount = totalCount;
		this.ps = ps;
		this.list = list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc = totalCount/ps;
		if(totalCount%ps != 0) tpc++;
		return tpc;
	}
	
}
