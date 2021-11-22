import java.util.*;

class  A3
{
	Vector<String> v = new Vector<String>();
	
	void in(){
		v.add("¿œ");v.add("¿Ã");v.add("ªÔ");v.add("ªÁ");
	}
	void out(){
		for (String str: v) System.out.println("str: "+str);
		
	}

	public static void main(String[] args) 
	{
		A3 a = new A3();
		a.in();
		a.out();
	}
}
