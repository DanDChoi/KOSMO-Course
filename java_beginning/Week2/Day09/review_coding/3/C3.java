import java.util.*;

class C3
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "����");ht.put(2, "ȣ����");ht.put(3, "����");ht.put(4, "��");
	}
	void out(){
		Set<Integer> keys = ht.keys();
		for(int key: keys)
			System.out.println("key: "+key+", value: "+value);
		}
	}
	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();
	}
}