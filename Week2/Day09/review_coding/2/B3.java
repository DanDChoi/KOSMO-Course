import java.util.*;

class B3
{
	TreeSet<String> ts = new TreeSet<String>();

	void in(){
		ts.add("¿œ");ts.add("¿Ã");ts.add("ªÔ");ts.add("ªÁ");
	}

	void out(){
		for(String str: ts) System.out.println("Str:"+str);
		
		}
	}

	public static void main(String[] args) 
	{
		B3 b = new B3();
		b.in();
		b.out();

	}
}
