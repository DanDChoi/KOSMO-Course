class E4 
{
	String strs[] = {"하나", "둘", "셋", "넷"};
	void out(){
	
	for (int i=0; i<strs.length; i++)
	{	System.out.println("strs["+i+"]: "+strs[i]);
	}
	}

	public static void main(String[] args) 
	{
		new E4().out();
	}
}
