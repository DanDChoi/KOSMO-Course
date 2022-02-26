//class가 아닌 interface로 만들것

package dan.md.mapper;

import java.util.List;

import dan.md.domain.Address;

public interface AddressMapper {
	List<Address> list();
	void insert(Address address);
	void delete(long seq); 
	
}
