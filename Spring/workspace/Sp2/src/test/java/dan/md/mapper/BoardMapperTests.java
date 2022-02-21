package dan.md.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testList() {
		log.info("#BoardMapperTests testList: " + boardMapper.list());
	}
	/*
	@Test
	public void testInsert() {
		Board board = new Board(-1L, "작성자", "이메일", "제목", "내용", null);
		boardMapper.insert(board);
		log.info("#BoardMapperTests testInsert() 수행성공");
	}
	
	@Test
	public void testDelete() {
		long seq = 16L;
		boardMapper.delete(seq);
		log.info("#BoardMapperTests testDelete() 수행성공");
	}
	
	@Test
	public void testContent() {
		long seq = 2L;
		//boardMapper.content(seq); 다른방법 찾아야함
		log.info("#BoardMapperTests testContent() 수행성공");
	}
	@Test
	public void testGetUpdate() {
		long seq = 1L;
		//boardMapper.getUpdate(seq);
		log.info("#BoardMapperTests testGetUpdate() 수행성공");
		
	}
	
	@Test
	public void testUpdate() {
		long seq =1L;
		Board board = new Board("테스트", "테스트", "테스트", "테스트", seq);
		boardMapper.Update(board);
	}
	*/
}
