package team1.togather.model;

class GroupTabSQL {
	static final String GROUP_LIST = "select * from GROUPTAB";
	static final String GROUP_INFO = "select * from GROUPTAB where GSEQ=?";
	static final String GROUP_CREATE = "insert into GROUPTAB values(GROUP_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?,SYSDATE)";
}
