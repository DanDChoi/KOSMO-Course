import java.util.*;

class C1{

	Hashtable ht = new Hashtable();

	void in(){
		ht.put(10, "가");ht.put(20, "나");ht.put(30, "다");ht.put(40, "라");
	}
	void out(){
		Enumeration e = ht.keys();
		while(e.hasMoreElements()){
			Object keyObj = e.nextElement();
			Integer keyRef = (Integer)keyObj;
			int key = keyRef.intValue();
			Object valObj = ht.get(keyRef);
			String value = (String)valObj;
			pln("key: "+key+", value: "+value);
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
