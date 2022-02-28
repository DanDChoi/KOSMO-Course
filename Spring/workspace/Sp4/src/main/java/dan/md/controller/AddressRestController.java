package dan.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dan.md.domain.Address;
import dan.md.service.AddressAjaxService;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("rest_addr")
public class AddressRestController { //CRUD
	@Autowired
	private AddressAjaxService service;
	
	//(1) Create (insert)
	/*
	@PostMapping("create")
	public void create(Address address) { //Parameter를 jsObj로 받을 때
		log.info("#AddressRestController create() address: " + address);
		service.insertS(address);
	}
	*/
	
	@PostMapping("create")
	public void create(@RequestBody Address address) { //Parameter를 JSON으로 받을 떄
		log.info("#AddressRestController create() address: " + address);
		service.insertS(address);
	}
	//http://127.0.0.1:8080/reset_addr/create 또는 create.xml 또는 create.json
	//{"seq":-1, "name":"이름", "addr":"주소"}
	//{"name":"이름2", "åddr":"주소2"}
	//============================================================================
	
	//(2) Read (select)
	@GetMapping("read")
	public List<Address> read() {
		List<Address> list = service.listS();
		return list;
	}
	//http://127.0.0.1:8080/reset_arrr/read 또는 read.xml 또는 read.json
	@GetMapping("read/{seq}")
	public Address read(@PathVariable long seq) {
		Address address = service.selectBySeqS(seq);
		return address;
	}
	//http://127.0.0.1:8080/rest_Addr/read/13.json
	@GetMapping(value="read", params = {"na"})
	public List<Address> read(@RequestParam("na") String name) {
		List<Address> list = service.selectByNameS(name);
		return list;
	}
	//http://127.0.0.1:8080/rest_Addr/read.json?na=가
	//============================================================================
	//(3) Update
	@PostMapping("update")
	public void update() {
		
	}
	//============================================================================
	//(4) Delete
	@DeleteMapping("delete/{seq}")
	public void delete(@PathVariable long seq) {
		service.deleteS(seq);
	}
	//http://127.0.0.1:8080/rest_Addr/delete/13.json
}

