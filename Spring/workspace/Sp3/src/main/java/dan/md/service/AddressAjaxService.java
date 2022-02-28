package dan.md.service;

import java.util.List;

import dan.md.domain.Address;
import dan.md.domain.Board;

public interface AddressAjaxService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
	
	Address selectBySeqS(long seq);
	List<Address> selectByNameS(String name);
}


