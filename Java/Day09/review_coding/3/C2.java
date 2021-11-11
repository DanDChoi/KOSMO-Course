import java.util.*;

class C2 
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "»çÀÚ");ht.put(2, "È£¶ûÀÌ");ht.put(3, "´Á´ë");ht.put(4, "°õ");
	}
	void out(){
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements()){
			Integer keyRef = e.nextElement();
			int key = keyRef.intValue();
			String value = ht.get(keyRef);
			System.out.println("key: "+key+", value: "+value);
		}
	}
	public static void main(String[] args) 
	{
		C2 c = new C2();
		c.in();
		c.out();
	}
}
