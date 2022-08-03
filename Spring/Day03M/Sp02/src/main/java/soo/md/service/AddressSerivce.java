package soo.md.service;

import java.util.List;

import soo.md.domain.Address;

public interface AddressSerivce {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
}
