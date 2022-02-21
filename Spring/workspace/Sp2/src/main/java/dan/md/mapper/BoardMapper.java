package dan.md.mapper;

import java.util.List;

import dan.md.domain.Board;

public interface BoardMapper {
	List<Board> list();
	void insert(Board board);
	void delete(long seq);
	List<Board> content(long seq);
	List<Board> getUpdate(long seq);
	void update(Board board);
}
