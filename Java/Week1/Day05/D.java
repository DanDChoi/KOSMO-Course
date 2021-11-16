class D 
{
	int a = 5;
	int b = 2;
		 
	void m1(){
		int i = a/b; //‘œ
		int j = a%b; //³ª¸ÓÁö
		System.out.println("i : " + i  + ", j: " + j);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
	}
}
