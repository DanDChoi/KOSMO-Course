package dan.md.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dan.md.domain.Board;
import dan.md.domain.BoardListResult;
import dan.md.domain.BoardVo;
import dan.md.mapper.BoardMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(cp, ps);
		List<Board> list = boardMapper.selectPerPage(boardVo);
		return new BoardListResult(cp, ps, totalCount, list);
	}

	@Override
	public Board getBoard(long seq) {
		Board board = boardMapper.selectBySeq(seq);
		return null;
	}

	@Override
	public void write(Board board) {
		boardMapper.insert(board);

	}

	@Override
	public void edit(Board board) {
		boardMapper.update(board);

	}

	@Override
	public void remove(long seq) {
		boardMapper.delete(seq);

	}

}
