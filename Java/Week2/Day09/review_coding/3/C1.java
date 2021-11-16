import java.util.*;

class C1 
{
	Hashtable ht = new Hashtable();

	void in(){
		ht.put(1, "»çÀÚ");ht.put(2, "È£¶ûÀÌ");ht.put(3, "´Á´ë");ht.put(4, "°õ");
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements()){
			Object keyObj = e.nextElement();
			Integer keyRef = (Integer)keyObj;
			int key = keyRef.intValue();
			Object valObj = ht.get(keyRef);
			String value = (String)valObj;
			System.out.println("key: "+key+", value: "+value);
		}
	}
	public static void main(String[] args) 
	{
		C1 c = new C1();
		c.in();
		c.out();
	}
}
