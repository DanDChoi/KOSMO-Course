import java.util.*;

class  A2
{
	Vector<String> v = new Vector<String>();

	void in(){
		v.add("����");v.add("��");v.add("ȣ����");v.add("����");
	}
	void out(){
		for (int i=0; i<v.size(); i++)
		{
			String str = v.get(i);
			System.out.println("str: "+ str);
		}
	}

	public static void main(String[] args) 
	{
		A2 a = new A2();
		a.in();
		a.out();
	}
}