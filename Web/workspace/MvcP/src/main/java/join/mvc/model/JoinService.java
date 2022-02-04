package join.mvc.model;

import mvc.domain.Member;

public class JoinService {
	private JoinDAO dao;
	
	private static final JoinService instance = new JoinService();
	private JoinService() {
		dao = new JoinDAO();
	}
	public static JoinService getInstance() {
		return instance;
	}
}