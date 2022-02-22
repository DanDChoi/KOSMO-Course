package dan.md.mapper;

import java.util.List;

import dan.md.domain.Board;
import dan.md.domain.BoardVo;

public interface BoardMapper {
	List<Board> selectPerPage(BoardVo boardVo);
	Board selectBySeq(long seq);
	long selectCount();
	
	void insert(Board board);
	void update(Board board);
	void delete(long seq);
	/*
	List<Board> list();
	void insert(Board board);
	void delete(long seq);
	List<Board> content(long seq);
	List<Board> getUpdate(long seq);
	void update(Board board);
	*/
}
