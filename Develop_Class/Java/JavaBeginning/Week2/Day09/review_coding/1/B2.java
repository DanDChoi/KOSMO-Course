import java.util.*;

class B2
{
	TreeSet<String> ts = new TreeSet<String>();

	void in(){
		ts.add("5");ts.add("2");ts.add("9");ts.add("3");
	}
	void out(){
		Iterator<String> iter = ts.descendingIterator();
		while(iter.hasNext()){
			String str = iter.next();
			System.out.println("str: " + str);
		}
	}

	public static void main(String[] args) 
	{
		B2 b = new B2();
		b.in();
		b.out();
	}
}
