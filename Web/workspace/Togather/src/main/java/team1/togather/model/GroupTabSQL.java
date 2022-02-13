package team1.togather.model;

class GroupTabSQL {
	static final String GROUP_LIST = "select * from GROUPTAB order by GSEQ desc";
	static final String GROUP_SELECT = "select * from GROUPTAB where GSEQ=?";
	static final String GROUP_INSERT = "insert into GROUPTAB values(GROUPTAB_SEQ.nextval, ?, ?, ?, ?, ?, SYSDATE, ?)";
	static final String GROUP_UPDATE = "update GROUPTAB set GLOC=?, GNAME=?, GINTRO=?, LIMIT=? WHERE GSEQ=?";
	static final String GATHERING_INSERT = "insert into GATHERING values(GATHERING_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
	static final String GATHERING_LIST = "select * from GATHERING where GSEQ=? order by GT_SEQ desc";
}
