import java.util.*;

class B2
{
	TreeSet<String> ts = new TreeSet<String>();

	void in(){
		ts.add("¿œ");ts.add("¿Ã");ts.add("ªÔ");ts.add("ªÁ");
	}

	void out(){
		Iterator<String> iter = ts.iterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println("str: "+str);
		}
	}

	public static void main(String[] args) 
	{
		B2 b = new B2();
		b.in();
		b.out();

	}
}
