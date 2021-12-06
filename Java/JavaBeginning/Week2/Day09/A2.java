import java.util.*;

class A2
{
	Vector<String> v = new Vector<String>(); //Generic
	
	void in(){
		v.add("봄");v.add("여름");v.add("가을");v.add("겨울");v.add("가을");
	}
	void out(){
		for(int i=0; i<v.size(); i++){
			String str = v.get(i);
			pln("str: " + str);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		A2 a = new A2();
		a.in();
		a.out();
	}
}