class E1 
{
	String strs[] = {"��", "��", "��", "��"};
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
