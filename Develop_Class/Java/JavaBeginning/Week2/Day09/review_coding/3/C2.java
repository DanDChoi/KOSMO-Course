import java.util.*;

class C2 
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "����");ht.put(2, "ȣ����");ht.put(3, "����");ht.put(4, "��");
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
