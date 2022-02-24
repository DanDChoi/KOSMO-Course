class D 
{
	String items[] = {"a", "b", "c", "d"};

	void out(){
		for(String item: items) System.out.println(item);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.out();
	}
}
