package dan.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dan.md.domain.Board;
import dan.md.domain.BoardListResult;
import dan.md.domain.BoardVo;
import dan.md.fileset.Path;
import dan.md.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
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
		log.info("#BoardServiceImpl getBoard: " + board.getWriter());
		return board;
	}
	@Override
	public void write(Board board, MultipartFile file) {
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf(".");
		String ofheader = ofname.substring(0, idx);
		String ext = ofname.substring(idx);
		long ms = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		String saveFileName = sb.toString();
		
		long fsize = file.getSize();
		
		board.setFname(saveFileName);
		board.setOfname(ofname);
		board.setFsize(fsize);
		
		boolean flag = writeFile(file, saveFileName);
		if(flag) {
			log.info("#업로드 성공");
		}else {
			log.info("#업로드 실패");
		}
		System.out.println("#BoardServiceImple :" + board.getFname());
		boardMapper.insert(board);
	}
	private boolean writeFile(MultipartFile file, String saveFileName) {
		File dir = new File(Path.FILE_STORE);
		if(!dir.exists()) dir.mkdirs();
		
		FileOutputStream fos = null;
		
		try {
			byte data[] = file.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE+saveFileName);
			fos.write(data);
			fos.flush();
			
			return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				if(fos != null) fos.close();
			}catch(IOException ie) {}
		}
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
