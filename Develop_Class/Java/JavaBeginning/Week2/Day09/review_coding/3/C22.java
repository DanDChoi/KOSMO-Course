import java.util.*;

class C22 
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "����");ht.put(2, "ȣ����");ht.put(3, "����");ht.put(4, "��");
	}
	void out(){
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements()){
			int key = e.nextElement();
			String value = ht.get(key);
			System.out.println("key: "+key+", value: "+value);
		}
	}
	public static void main(String[] args) 
	{
		C22 c = new C22();
		c.in();
		c.out();
	}
}
