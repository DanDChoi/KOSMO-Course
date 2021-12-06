import java.util.*;

class  A3
{
	Vector<String> v = new Vector<String>();

	void in(){
		v.add("»çÀÚ");v.add("°õ");v.add("È£¶ûÀÌ");v.add("´Á´ë");
	}
	void out(){
		for (String str: v) System.out.println("str: "+ str);
		
	}

	public static void main(String[] args) 
	{
		A3 a = new A3();
		a.in();
		a.out();
	}
}