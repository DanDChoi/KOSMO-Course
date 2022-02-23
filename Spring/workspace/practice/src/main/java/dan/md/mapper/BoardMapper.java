package dan.md.mapper;

import java.util.List;

import dan.md.domain.Board;
import dan.md.domain.BoardVo;

public interface BoardMapper {
	List<Board> selectPerPage(BoardVo boardVo);
	long selectCount();
	Board selectBySeq(long seq);
	
	void insert(Board board);
	void update(Board board);
	void delete(long seq);
}
