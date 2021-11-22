class D {
	void m1() throws MyException {
		boolean flag = false;
		if(flag){
			throw new MyException();
		}
	}
	void m2() throws YourException {
		boolean flag = false;
		if(flag){
			throw new YourException();
		}
	}
	void m3() throws Exception {
		boolean flag = true;
		if(flag){
			throw new Exception();
		}
	}
}
/*
class DUser {
	public static void main(String[] args) {
		D d = new D();
		try{
			System.out.println("1");
			d.m1();  
			System.out.println("2");
			d.m2(); 
			System.out.println("3");
			d.m3();
			System.out.println("4");
		}catch(MyException me){
			me.use();
		}catch(YourException ye){
			ye.apply();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("5");
	}
}*/
class DUser{
	DUser() throws YourException, Exception{
		D d = new D();
		try{
			d.m1();
			d.m2();
			d.m3();
		}catch(MyException me){
			me.use();
		}
	}
	public static void main(String[] args) {
		try{
			new DUser();
		}catch(YourException ye){
			ye.apply();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
