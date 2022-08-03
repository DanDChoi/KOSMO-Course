package addr.mvc.model;

import java.util.ArrayList;

import mvc.domain.Board;

public class BoardService {
	private BoardDAO dao;
	private static final BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;
	}
	public ArrayList<Board> listS(){
		return dao.list();
	}
	public boolean insertS(Board dto) {
		return dao.insert(dto);
	}
	public void delS(int seq) {
		dao.del(seq);
	}
	public Board contentS(int seq) {
		return dao.content(seq);
	}
	public Board updateS(int seq) {
		return dao.update(seq);
	}
	public boolean updatedoS(Board dto) {
		return dao.updateDo(dto);
	}
}
