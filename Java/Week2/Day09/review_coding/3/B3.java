import java.util.*;

class B3 
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("»çÀÚ");ts.add("´Á´ë");ts.add("°õ");ts.add("È£¶ûÀÌ");
	}
	void out(){
		for(String str: ts) System.out.println("str: "+str);
		}
	}
	public static void main(String[] args) 
	{
		B3 b = new B3();
		b.in();
		b.out();
	}
}