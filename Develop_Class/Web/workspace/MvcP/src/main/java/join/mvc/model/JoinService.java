package join.mvc.model;

import static login.mvc.model.LoginConst.NO_ID;
import static login.mvc.model.LoginConst.NO_PWD;
import static login.mvc.model.LoginConst.YES_ID_PWD;

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
	public boolean insertS(Join dto) {
		return dao.insert(dto);
	}
	
	public int check(String email, String phone, String pwd, String pwdcheck) {
		Member m = dao.insert(email);
		if(m == null) {
			return NO_ID; //�׷� email�� ���� ȸ���� ����
		}else {
			String dbPwd = m.getPwd();
			if(dbPwd != null) dbPwd = dbPwd.trim();
			
			if(!dbPwd.equals(phone)) {
				return NO_PWD; //email�� ���������� ��й�ȣ�� �ٸ����
			}else {
				return YES_ID_PWD; //email �� pwd�� ����
			}
		}
	}
}