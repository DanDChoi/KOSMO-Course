import java.util.*;

class C22{

	Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

	void in(){
		ht.put(10, "��");ht.put(20, "��");ht.put(30, "��");ht.put(40, "��");
	}
	void out(){
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements()){
			int key = e.nextElement();
			String value = ht.get(key);
			pln("key: "+key+", value: "+value);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		C22 c = new C22();
		c.in();
		c.out();
	}
}