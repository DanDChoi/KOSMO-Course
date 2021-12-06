import java.util.*;

class  C3
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(1, "하나");ht.put(2, "둘");ht.put(3, "셋");ht.put(4, "넷");
	}
	void out(){
		Set<Integer> keys = ht.keySet();
		for(int key: keys)
			System.out.println("Key: "+key+", value: "+value);
	}

	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();
	}
}
