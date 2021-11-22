import java.util.*;

class  C1
{
	Hashtable ht = new Hashtable();

	void in(){
		ht.put(1, "하나");ht.put(2, "둘");ht.put(3, "셋");ht.put(4, "넷");
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements());
			Object keyObj = e.nextElement();
			Integer keyRef = (Integer)keyObj;
			int key = keyRef.intValue();
			Object valObj = ht.get(keyRef);
			String value = (String)valObj;
			System.out.println("Key: "+key+", value: "+value);
	}

	public static void main(String[] args) 
	{
		C1 c = new C1();
		c.in();
		c.out();
	}
}
