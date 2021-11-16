import java.util.*;

class A3
{
	Vector<String> v = new Vector<String>(); //Generic
	
	void in(){
		v.add("봄");v.add("여름");v.add("가을");v.add("겨울");v.add("가을");
	}
	void out(){
		for(String str: v) pln("str: " + str); //Enhanced Loop
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