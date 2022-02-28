package dan.md.service;

import org.springframework.web.multipart.MultipartFile;

import dan.md.domain.Board;
import dan.md.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	
	
	Board getBoard(long seq);
	void write(Board board, MultipartFile file);
	void edit(Board board);
	void remove(long seq);
	
	/*
	List<Board> listS();
	void insertS(Board board);
	void deleteS(long seq);
	List<Board> contentS(long seq);
	List<Board> getUpdateS(long seq);
	void updateS(Board board);
	*/
}
