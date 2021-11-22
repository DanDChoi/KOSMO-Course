import java.util.*;

class B2 
{
	TreeSet<String> ts = new TreeSet<String>(); //Generic
	void in(){
		ts.add("봄");ts.add("여름");ts.add("가을");ts.add("겨울");ts.add("가을");
	}
	void out(){
		//Iterator iter = ts.iterator();
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

