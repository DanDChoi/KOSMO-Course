import java.util.*;

class C3 
{
	Hashtable<Integer, String> ht = new Hashtable<Integer, String>(); //Generic

	void in(){//int -> Integer -> Object 
		ht.put(10, "봄");ht.put(20, "여름");ht.put(30, "가을");ht.put(40, "겨울");ht.put(30, "초가을");
	}
	void out(){
		Set<Integer> keys = ht.keySet();
		for(int key: keys) 
			System.out.println("key: " + key + ", value: " + ht.get(key));
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		C3 c = new C3();
		c.in();
		c.out();
	}
}
