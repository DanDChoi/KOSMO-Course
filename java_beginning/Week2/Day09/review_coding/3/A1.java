import java.util.*;

class  A1
{
	Vector v = new Vector();

	void in(){
		v.add("»çÀÚ");v.add("°õ");v.add("È£¶ûÀÌ");v.add("´Á´ë");
	}
	void out(){
		for (int i=0; i<v.size(); i++)
		{
			Object obj = (String)v.get(i);
			System.out.println("obj: "+ obj);
		}
	}

	public static void main(String[] args) 
	{
		A1 a = new A1();
		a.in();
		a.out();
	}
}
