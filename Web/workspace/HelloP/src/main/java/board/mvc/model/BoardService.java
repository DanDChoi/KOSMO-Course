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
	/*
	public void insertS(Board board) {
		dao.insert(board);
	}
	public void deleteS(long seq) {
		dao.delete(seq);
	}
	public Board contentS(long seq) {
		return dao.content(seq);
	}
	public void updateS(Board board){
		dao.update(board);
	}
	*/
}
