import java.util.*;

class B1
{
	TreeSet ts = new TreeSet();

	void in(){
		ts.add("5");ts.add("2");ts.add("9");ts.add("3");
	}
	void out(){
		Iterator iter = ts.descendingIterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			String str = (String)obj;
			System.out.println("str: " + str);
		}
	}

	public static void main(String[] args) 
	{
		B1 b = new B1();
		b.in();
		b.out();
	}
}
