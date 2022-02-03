package addr.mvc.model;

class AddrSQL {
	final static String LIST = "select * from address order by seq desc";
	final static String INSERT = "insert into address values(ADDRESS_SEQ.nextval, ?, ?, SYSDATE)";
	final static String DELETE = "delete from ADDRESS where SEQ=?";
}
