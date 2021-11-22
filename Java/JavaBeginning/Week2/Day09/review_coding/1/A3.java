import java.util.*;

class A3 
{
	Vector<String> v = new Vector<String>();

	void in(){
		v.add("1");v.add("2");v.add("3");v.add("4");
	}
	void out(){
		for(String str: v) pln("str: "+str);		
	}
	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		A3 a = new A3();
		a.in();
		a.out();
	}
}
