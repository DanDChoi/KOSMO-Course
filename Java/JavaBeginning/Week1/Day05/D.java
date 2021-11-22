class D 
{
	int a = 5;
	int b = 2;
		 
	void m1(){
		int i = a/b; //몫
		int j = a%b; //나머지
		System.out.println("i : " + i  + ", j: " + j);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
	}
}
