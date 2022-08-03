class E1 
{
	String strs[] = {"가", "나", "다", "라"};
	void out(){
		for (int i=0; i<strs.length; i++)
		{
			System.out.println("strs["+i}"]: "+strs[i]);
		}
	}

	public static void main(String[] args) 
	{
		new E1().out();
	}
}
