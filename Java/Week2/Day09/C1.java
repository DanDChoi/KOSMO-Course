import java.util.*;

class C1 
{
	Hashtable ht = new Hashtable();

	void in(){//int -> Integer -> Object 
		ht.put(10, "봄");ht.put(20, "여름");ht.put(30, "가을");ht.put(40, "겨울");ht.put(30, "초가을");
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements()){
			Object keyObj = e.nextElement();
			Integer keyRef = (Integer)keyObj;
			int key = keyRef.intValue();
			Object valObj = ht.get(keyRef);
			String value = (String)valObj;
            pln("key: " + key + ", value: " + value);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		C1 c = new C1();
		c.in();
		c.out();
	}
}
