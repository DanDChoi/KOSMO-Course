package addr.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddrService {
	@Autowired
	private AddrDAO dao;
	
	
}
