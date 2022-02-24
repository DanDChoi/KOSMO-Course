import java.util.*;

class A2 
{
	Vector<String> v = new Vector<String>();

	void in(){
		v.add("1");v.add("2");v.add("3");v.add("4");
	}
	void out(){
		for (int i=0; i<v.size(); i++){
			String str = v.get(i);
			pln("str: "+str);
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
