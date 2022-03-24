package dan.md.service;

import dan.md.domain.Board;
import dan.md.domain.BoardListResult;

public interface BoardService {
	BoardListResult getBoardListResult(int cp, int ps);
	Board getBoard(long seq);
	
	void write(Board board);
	void edit(Board board);
	void remove(long seq);
}
