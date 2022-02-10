package board.mvc.model;

class BoardSQL {
	static final String LIST = "select * from board order by seq desc";
	static final String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE, ?, ?)";
	static final String DELETE = "delete from Board where seq=?";	
	static final String CONTENT = "select * from BOARD where seq=?";
	static final String GETUPDATE = "select * from board where seq=?";
	static final String UPDATE = "update board set email=?, subject=?, content=?, fname=?, ofname=? where seq=?";
}