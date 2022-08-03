class B 
{
	int i;
	B() throws Exception {
		throw new Exception();
	}
	void m() throws Exception{
		throw new Exception();
	}

	public static void main(String[] args) { //throws Exception {
		try{
			B b = new B();
			b.m();
		}catch(Exception e){}
	}
}
