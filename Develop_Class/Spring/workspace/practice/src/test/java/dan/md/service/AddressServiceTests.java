package dan.md.service;

import java.util.List;

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
public class AddressServiceTests {
	@Autowired //@Setter(onMethod = {@Autowired}) 도 동일
	private AddressService addressService;
	/*
	@Test
	public void listS(){
		log.info("#AddressServiceTests addressService: "+ addressService);
		List<Address> list = addressService.listS();
		log.info("AddressServiceTests list: " + list);
	}
	
	
	@Test
	public void insertS() {
		Address address = new Address(-1L, "최민정", "대한민국", null);
		addressService.insertS(address);
		log.info("#AddressServiceTests insert() 완료");
	}
	*/
	@Test
	public void deleteS() {
		long seq = 6L;
		addressService.deleteS(seq);
		log.info("#AddressServiceTests delete() 완료");
	}
	
}
