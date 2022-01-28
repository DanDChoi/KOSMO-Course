package addr.mvc.model;

class BoardSQL {
	static final String LIST = "select * from board order by seq desc";
	static final String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
	static final String DELETE = "delete from Board where SEQ=?";	
	static final String CONTENT = "select * from BOARD where SEQ=?";
	static final String UPDATE = "select * from BOARD where SEQ=? order by seq desc";
}
