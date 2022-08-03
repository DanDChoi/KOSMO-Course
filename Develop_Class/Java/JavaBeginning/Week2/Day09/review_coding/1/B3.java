import java.util.*;

class B3
{
	TreeSet<String> ts = new TreeSet<String>();

	void in(){
		ts.add("5");ts.add("2");ts.add("9");ts.add("3");
	}
	void out(){
		for(String str: ts) System.out.println(str);
	}

	public static void main(String[] args) 
	{
		B3 b = new B3();
		b.in();
		b.out();
	}
}