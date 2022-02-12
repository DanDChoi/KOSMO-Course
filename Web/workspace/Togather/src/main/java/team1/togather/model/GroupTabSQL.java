package team1.togather.model;

class GroupTabSQL {
	static final String GROUP_LIST = "select * from GROUPTAB order by GSEQ desc";
	static final String GROUP_INFO = "select * from GROUPTAB where GSEQ=?";
	static final String GROUP_INSERT = "insert into GROUPTAB values(GROUPTAB_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, ?)";
	static final String GROUP_GET_UPDATE = "select * from GROUPTAB WHERE GSEQ=?";
	static final String GROUP_UPDATE = "update GROUPTAB set GLOC=?, GNAME=?, GINTRO=?, LIMIT=? WHERE GSEQ=?";
}
