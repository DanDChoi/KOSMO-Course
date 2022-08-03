import java.util.*;

class A1 
{
	Vector v = new Vector();

	void in(){
		v.add("1");v.add("2");v.add("3");v.add("4");
	}
	void out(){
		for (int i=0; i<v.size(); i++){
			Object obj = (String)v.get(i);
			pln("obj: "+obj);
		}
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		A1 a = new A1();
		a.in();
		a.out();
	}
}
