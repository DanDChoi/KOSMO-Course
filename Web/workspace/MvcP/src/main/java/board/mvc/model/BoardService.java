package board.mvc.model;

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

	public ArrayList<Board> contentS(int seq) {
		return dao.contentlist(seq);
	}
	public void deleteS(int seq) {
		dao.delete(seq);
	}
	
	public ArrayList<Board> getupdateS(int seq){
		return dao.getupdate(seq);
	}
	public void updateS(Board dto) {
		dao.update(dto);
	}
	
}
