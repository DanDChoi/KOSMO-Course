package dan.md.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	private int cp =1; //페이지번호
	private int ps =5; //페이지 사이즈
	
	public int getStartRow() {
		return (cp-1)*ps;
	}
	public int getEndRow(){
		return cp*ps;
	}
}
