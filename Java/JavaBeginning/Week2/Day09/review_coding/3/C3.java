import java.util.*;

class C3
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "»çÀÚ");ht.put(2, "È£¶ûÀÌ");ht.put(3, "´Á´ë");ht.put(4, "°õ");
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