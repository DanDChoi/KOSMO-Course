package addr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/addr")
public class AddrController {
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void list() {
		
	}
}
