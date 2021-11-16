class D 
{
	String items[] = {"1", "2", "3", "4"};

	void out(){
	for(String item: items){
		System.out.println("item: "+item);
		}
	}


	public static void main(String[] args) 
	{
		D d = new D();
		d.out();
	}
}
