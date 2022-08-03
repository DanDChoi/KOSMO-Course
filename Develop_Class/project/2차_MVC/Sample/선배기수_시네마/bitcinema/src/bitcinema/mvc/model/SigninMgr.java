package bitcinema.mvc.model;

import javax.servlet.http.HttpServletRequest;

public class SigninMgr
{
	private SigninDAO dao;
	
	private static final SigninMgr instance = new SigninMgr();
	
	private SigninMgr() {
		dao = new SigninDAO();
	}
	
	public static SigninMgr getInstance() {
		return instance;
	}

	public SigninDTO signinM(HttpServletRequest request){
		return dao.signin(request);
	}
	
	public int signupM(HttpServletRequest request){
		return dao.signup(request);
	}
}