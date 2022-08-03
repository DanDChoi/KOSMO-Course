package addr.mvc.model;

class BoardSQL {
	static final String LIST = "select * from BOARD order by SEQ desc";
	static final String DELELTE = "delete from BOARD where SEQ=?";
	static final String INSERT = "insert into BOARD values(BOARD_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
	static final String CONTENT = "select * from BOARD where SEQ=?";
	static final String UPDATE = "select * from BOARD where SEQ=?";
	static final String UPDATEDO = "update BOARD set WRITER=?, EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
}
