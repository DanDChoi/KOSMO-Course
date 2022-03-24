package dan.md.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dan.md.domain.Board;
import dan.md.domain.BoardListResult;
import dan.md.fileset.Path;
import dan.md.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("list.do")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		
		//(1) cp 
		int cp = 1;
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		
		//(3) ModelAndView 
		BoardListResult listResult = boardService.getBoardListResult(cp, ps);
		ModelAndView mv = new ModelAndView("board/list", "listResult", listResult);
		
		if(listResult.getList().size() == 0) {
			if(cp > 1)
				return new ModelAndView("redirect:list.do?cp="+(cp-1));
			else 
				return new ModelAndView("board/list", "listResult", null);
		}else {
			return mv;
		}
	}
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("write.do")
	public String write(Board board, @RequestParam MultipartFile file) {
		String ofname = file.getOriginalFilename();
		if(ofname != null) ofname = ofname.trim();
		if(ofname.length() != 0) {
			boardService.write(board, file);;
		}
		return "redirect:list.do";
	}
	@GetMapping("content.do")
	public ModelAndView content(long seq) {
		Board board = boardService.getBoard(seq);
		System.out.println("###BoardController content: "+ board.getSubject());
		ModelAndView mv = new ModelAndView("board/content", "board", board);
		return mv;
	}
	@GetMapping("update.do")
	public ModelAndView update(long seq) {
		Board board = boardService.getBoard(seq);
		ModelAndView mv = new ModelAndView("board/update", "board", board);
		return mv;
	}
	@PostMapping("update.do")
	public String update(Board board) {
		boardService.edit(board);
		return "redirect:list.do";
	}
	@GetMapping("del.do")
	public String delete(long seq) {
		boardService.remove(seq);
		return "redirect:list.do";
	}
	@GetMapping("download.do")
	public ModelAndView download(String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);
		}else {
			return new ModelAndView("redirect:list.do");
		}
	}
	
	/*
	@GetMapping("/list.do")
	public ModelAndView list() {
		List<Board> list = boardService.listS();
		ModelAndView mv = new ModelAndView("board/list", "list", list);
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write.do")
	public String write(Board board) {
		boardService.insertS(board);
		return "redirect:list.do";
	}
	@GetMapping("/del.do")
	public String delete(long seq) {
		boardService.deleteS(seq);
		return "redirect:list.do";
	}
	@GetMapping("/content.do")
	public ModelAndView content(long seq) {
		List<Board> content = boardService.contentS(seq);
		ModelAndView mv = new ModelAndView("board/content", "content", content);
		return mv;
	}
	@GetMapping("/getUpdate.do")
	public ModelAndView getUpdate(long seq) {
		List<Board> getUpdate = boardService.getUpdateS(seq);
		ModelAndView mv = new ModelAndView("board/getUpdate", "getUpdate", getUpdate);
		return mv;
	}
	@PostMapping("/update.do")
	public String update(Board board) {
		boardService.updateS(board);
		return "redirect:list.do";
	}
	*/
	
}
