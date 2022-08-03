package soo.md.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TxSampleServiceTests {
	@Autowired
	private TxSampleService service;
	
	
	@Test
	public void testAddDatas() {
		//String data = "스프링";
		String data = "가을엔 편지를 하겠어요 누구라도 그대가 되어 받아주세요";
		
		long len = data.getBytes().length;
		log.info("#입력하려는 바이트수: " +len);
		
		service.addDatas(data);
	}
}
