import java.util.*;

class B1
{
	TreeSet ts = new TreeSet();

	void in(){
		ts.add("��");ts.add("��");ts.add("��");ts.add("��");
	}

	void out(){
		Iterator iter = ts.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			String str = (String)obj;
			System.out.println("str: "+str);
		}
	}

	public static void main(String[] args) 
	{
		B1 b = new B1();
		b.in();
		b.out();

	}
}
