package dan.ct.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dan.ct.domain.Human;
import dan.ct.domain.HumanList;
import dan.ct.domain.ToDoDTO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
//@RequestMapping("/test/*")
@RequestMapping("/test")
public class TestController {
	@RequestMapping("")
	public void m01() {
		// System.out.println("#m01() - default URL");
		log.info("#m01() - default URL");
	}

	@RequestMapping("/base1")
	public void m02() {
		// System.out.println("#m02() - Get방식 & Post방식 & ...");
		log.info("#m01() - default URL");
	}

	@RequestMapping(value = "/base2", method = RequestMethod.GET)
	public void m03() {
		//System.out.println("#m03() - Get방식");
		log.info("#m01() - default URL");
	}

	@RequestMapping(value = "/base3", method = { RequestMethod.GET, RequestMethod.POST })
	public void m04() {
		log.info("#m04() - Get방식 & Post방식");
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "test/form";
	}

	/*
	 * @RequestMapping(value="/param1", method = RequestMethod.GET) public void
	 * m05(String name) { System.out.println("#m05() - name:" + name); }
	 */
	@RequestMapping(value = "/param1", method = RequestMethod.GET)
	public void m05(@RequestParam("na") String name, int age) { // 넘어오는 파라미터의 이름이 같은경우 @RequestParam("파라미터이름") 생략가능
		log.info("#m05() - name:" + name + ", age: " + age);
	}

	@RequestMapping(value = "/param2", method = RequestMethod.GET)
	public void m06(Human dto) {
		log.info("#m06() -dto:" + dto);
	}
	@RequestMapping(value = "/param3")
	public void m07(@RequestParam ArrayList<String> names) { //@RequestParam을 무조건 써야함.
		log.info("#m07() - names:" + names);
	}
	@RequestMapping(value = "/param4")
	public void m08(@RequestParam("ns") ArrayList<String> names) {
		log.info("#m08() - names:" + names);
	}
	@RequestMapping(value = "/param5")
	public void m09(@RequestParam String[] names) {
		log.info("#m09() - names:" + names);
		for(String name: names) log.info("#name: "+ name);
	}
	
	@RequestMapping(value = "/param6")
	public void m10(HumanList hList) { //dto 객체를 멤버변수로 갖고있는 class를 생성 (dan.ct.domain.HumanList)
		log.info("#m10() - Hlist:" + hList);
	}
	@RequestMapping(value = "/param7")
	public void m11(Human dto, String dump, @RequestParam("s") int seq) {
		log.info("#m11() - dto: " + dto +", dump: " + dump + ", seq: " + seq);
	}
	@RequestMapping("/param8")
	public void m12(ToDoDTO dto) {
		log.info("#m12() - dto: " + dto);
		Date cdate = dto.getCdate();
		showDate(cdate);
		}
	
	private void showDate(Date cdate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(cdate);
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d1 = cal.get(Calendar.DATE);
		int d2 = cal.get(Calendar.DAY_OF_WEEK);
		String day = "";
		switch(d2) {
			case 1: day = "일"; break;
			case 2: day = "월"; break;
			case 3: day = "화"; break;
			case 4: day = "수"; break;
			case 5: day = "목"; break;
			case 6: day = "금"; break;
			case 7: day = "토"; break;
		}

		log.info("#m12() - y: " + y +"년 "+ (m+1) + "월 " + d1 + "일  (" +day+"요일)" );
	}
	

}
