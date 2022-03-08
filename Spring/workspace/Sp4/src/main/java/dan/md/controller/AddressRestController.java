package dan.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j;
import dan.md.domain.Address;
import dan.md.service.AddressAjaxService;

@Log4j
@RestController
@RequestMapping("rest_addr")
@CrossOrigin(origins = "*", maxAge = 3600) //#매우 중요!
public class AddressRestController { //CRUD
	@Autowired
	private AddressAjaxService service;
	
	//(1) Create( insert )
    /*@PostMapping("create")
    public void create(Address address) { //파라미터를 jsObj로 받을때  
    	log.info("#AddressRestController create() address: " + address);
    	service.insertS(address);
    }*/
	@PostMapping("create")
    public void create(@RequestBody Address address) { //파라미터를 JSON을 받을 때 
    	log.info("#AddressRestController create() address: " + address);
    	service.insertS(address);
    }
    //http://127.0.0.1:8080/rest_addr/create 또는 create.xml 또는 create.json
    //at React => http://127.0.0.1:8080/rest_addr/create.json
    //{"seq":-1, "name":"병철", "addr":"도쿄"}	
	//{"name":"병철2", "addr":"도쿄2"}	
	
	//(2) Read ( select )
	@GetMapping("read")
	public List<Address> read(){
		List<Address> list = service.listS();
		return list;
	}
	//http://127.0.0.1:8080/rest_addr/read 또는 read.xml 또는 read.json
	//at React => http://127.0.0.1:8080/rest_addr/read.json
	
	@GetMapping("read/{seq}")
	public Address read(@PathVariable long seq){
		Address address = service.selectBySeqS(seq);
		return address;
	}
	//http://127.0.0.1:8080/rest_addr/read/13.json
	//at React => http://127.0.0.1:8080/rest_addr/read/16.json
	
	@GetMapping(value="read", params = {"na"})
	public List<Address> read(@RequestParam("na") String name){
		List<Address> list = service.selectByNameS(name);
		return list;
	}
	//http://127.0.0.1:8080/rest_addr/read.json?na=가
	//at React => http://127.0.0.1:8080/rest_addr/read.json?na=병철
	
	//아래도 가능은 하나 위의 방법을 추천 
	/*@GetMapping("read/{name}") //@GetMapping("read/{seq}")와 공존할 순 없음
	public List<Address> read(@PathVariable String name){
		log.info("#name: " + name);
		List<Address> list = service.selectByNameS(name);
		return list;
	}*/
	//http://127.0.0.1:8080/rest_addr/read/가
	
	
	//(3) Delete (delete)
	@DeleteMapping("delete/{seq}")
	public void delete(@PathVariable long seq) {
		service.deleteS(seq);
	}
	//http://127.0.0.1:8080/rest_addr/delete/13.json
	//at React => http://127.0.0.1:8080/rest_addr/delete/8.json
}
