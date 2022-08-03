class E2 
{
	String strs[] = {"a", "b", "c", "d"};
	void out(){
		for (int i=0; i<strs.length; i++)
		{ System.out.println("strs["+i+"]: "+strs[i]);
		}
	}
	public static void main(String[] args) 
	{
		new E2().out();
	}
}
