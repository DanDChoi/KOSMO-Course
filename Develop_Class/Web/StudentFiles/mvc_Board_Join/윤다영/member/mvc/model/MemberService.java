package member.mvc.model;

import mvc.domain.Member;

public class MemberService {
	private MemberDAO dao;
	
	private static final MemberService instance = new MemberService();
	
	private MemberService() {
		dao = new MemberDAO();
	}
	
	public static MemberService getInstance() {
		return instance;
	} 
	
	public boolean signUpInsertS(Member dto) {
		return dao.signUpInsert(dto);
	}
	
	public boolean signInS(Member dto) {
		if(dao.checkExistId(dto)) {
			if(dao.checkPwd(dto)) {
				return true;
			}
		}
		return false;
	}
	
	public Member getUserS(String id) {
		return dao.getUser(id);
	}
}
