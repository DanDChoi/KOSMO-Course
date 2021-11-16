class B2 
{
	int i;
	B2() throws Exception {
		throw new Exception();
	}
	void m() throws Exception{
		throw new Exception();
	}

	public static void main(String[] args) { 
		try{
			B2 b = new B2();
			b.m();
		}catch(Exception e){}
	}
}
