package dan.md.service;

import java.util.List;

import dan.md.domain.Board;

public interface BoardService {
	List<Board> listS();
	void insertS(Board board);
	void deleteS(long seq);
	List<Board> contentS(long seq);
	List<Board> getUpdateS(long seq);
	void updateS(Board board);
}
