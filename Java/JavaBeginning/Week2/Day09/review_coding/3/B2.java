import java.util.*;

class B2 
{
	TreeSet<String> ts = new TreeSet<String>();
	void in(){
		ts.add("»çÀÚ");ts.add("´Á´ë");ts.add("°õ");ts.add("È£¶ûÀÌ");
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