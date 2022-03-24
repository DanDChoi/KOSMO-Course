package dan.md.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dan.md.domain.Address;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressMapperTests {
	@Autowired
	private AddressMapper addressMapper;

	/*@Test
	public void testList() {
		log.info("#AddresMapperTests testList: " + addressMapper.list());
	}*/
	/*@Test
	public void testInsert() {
		Address address = new Address(-1L, "스프링", "모델", null);
		addressMapper.insert(address);
		log.info("#AddresMapperTests testInsert() 수행 성공 ");
	}*/
	@Test
	public void testDelete() {
		long seq = 5L;
		addressMapper.delete(seq);
		log.info("#AddresMapperTests testDelete() 수행 성공 ");
	}
}
