package dan.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
	@RequestMapping("about.html")
	public String about() {
		return "about";
	}
	@RequestMapping("blog.html")
	public String blog() {
		return "blog";
	}
	@RequestMapping("codes.html")
	public String codes() {
		return "codes";
	}
	@RequestMapping("contract.html")
	public String contract() {
		return "contract";
	}
	@RequestMapping("index.html")
	public String index() {
		return "index";
	}
	@RequestMapping("menu.html")
	public String menu() {
		return "menu";
	}
	@RequestMapping("single.html")
	public String single() {
		return "single";
	}
}
