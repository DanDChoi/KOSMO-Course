package member.mvc.model;

public class MemberSQL {
	final static String SIGNUPINSERT = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, SYSDATE)";
	final static String CHECKEXISTID = "select * from MEMBER where ID = ?";
	final static String CHECKPWD = "select PWD from MEMBER where ID = ?";
}
