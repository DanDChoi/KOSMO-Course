package join.mvc.model;

class JoinSQL {
	final static String INSERT = "insert into MEMBER(SEQ, NAME, EMAIL, PWD, PHONE, RDATE, UDATE) values(MEMBER_SEQ.nextval, ?, ?, ?, ?, SYSDATE, SYSDATE)";
}
