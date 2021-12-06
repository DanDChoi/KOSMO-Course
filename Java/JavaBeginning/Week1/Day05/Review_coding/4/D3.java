class D3 
{
	int a = 234578;
	int b = 243;
	
	void m1(){
		int i = a/b;
		int j = a%b;
		System.out.println("¸ò: "+i+",³ª¸ÓÁö : "+j);
	}
	public static void main(String[] args) 
	{
		D3 d3 = new D3();
		d3.m1();
	}
}
