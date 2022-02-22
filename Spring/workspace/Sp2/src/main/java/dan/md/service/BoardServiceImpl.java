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
	
	private BoardMapper boardMapper; //저절로 객체주입 spring 4.3~ AutoInjection
	
	@Override
	public BoardListResult getBoardListResult(int cp, int ps) {
		long totalCount = boardMapper.selectCount();
		BoardVo boardVo = new BoardVo(cp, ps);
		List<Board> list = boardMapper.selectPerPage(boardVo);
		return new BoardListResult(cp, totalCount, ps, list);
	}
	@Override
	public Board getBoard(long seq) {
		Board board = boardMapper.selectBySeq(seq);
		return board;
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
	
	/*
	@Override
	public List<Board> listS(){
		return boardMapper.list();
	}
	
	@Override
	public void insertS(Board board) {
		boardMapper.insert(board);
	}
	
	@Override
	public void deleteS(long seq) {
		boardMapper.delete(seq);
	}
	
	@Override
	public List<Board> contentS(long seq) {
		return boardMapper.content(seq);
	}
	
	@Override
	public List<Board> getUpdateS(long seq) {
		return boardMapper.getUpdate(seq);
	}
	
	@Override
	public void updateS(Board board) {
		boardMapper.update(board);
	}
	*/
}
