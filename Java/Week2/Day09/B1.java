import java.util.*;

class B1 
{
	TreeSet ts = new TreeSet();
	void in(){
		ts.add("봄");ts.add("여름");ts.add("가을");ts.add("겨울");ts.add("가을");
	}
	void out(){
		//Iterator iter = ts.iterator();
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
