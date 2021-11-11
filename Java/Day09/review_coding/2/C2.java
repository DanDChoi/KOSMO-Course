import java.util.*;

class  C2
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "하나");ht.put(2, "둘");ht.put(3, "셋");ht.put(4, "넷");
	}
	void out(){
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements());
			Integer keyRef = e.nextElement();
			int key = keyRef.intValue();
			String value= ht.get(keyRef);	
			System.out.println("Key: "+key+", value: "+value);
	}

	public static void main(String[] args) 
	{
		C2 c = new C2();
		c.in();
		c.out();
	}
}
