import java.util.*;

class  C22
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "하나");ht.put(2, "둘");ht.put(3, "셋");ht.put(4, "넷");
	}
	void out(){
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements());
			int key = e.nextElement();
			String value= ht.get(keyRef);	
			System.out.println("Key: "+key+", value: "+value);
	}

	public static void main(String[] args) 
	{
		C22 c = new C22();
		c.in();
		c.out();
	}
}
