class E3 
{
	String strs[] = {"q", "w", "e", "r"};
	void out(){
		for (int i=0; i<strs.length; i++)
		{System.out.println("strs["+i+"]: "+strs[i]);
		}
	}
	public static void main(String[] args) 
	{
		new E3().out();
	}
}
