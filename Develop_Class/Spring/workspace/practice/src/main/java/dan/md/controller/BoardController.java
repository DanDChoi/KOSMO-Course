package dan.md.controller;

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
	
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}
	@PostMapping("write.do")
	public String write(Board board) {
		boardService.write(board);
		return "redirect:list.do";
	}
	@GetMapping("content.do")
	public ModelAndView content(long seq) {
		Board board = boardService.getBoard(seq);
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
}
