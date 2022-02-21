package dan.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dan.md.domain.Board;
import dan.md.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
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
	
}
