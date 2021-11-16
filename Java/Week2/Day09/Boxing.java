class Boxing 
{
	int i = 10;
	Integer iObj;

	void m1(){
		//Integer iObj = new Integer(i); //(JDK5미만)
		iObj = i; // AutoBoxing(JDK5이상~)
	}
	void m2(){
		//int j = iObj.intValue(); //(JDK5미만)
		int j = iObj; //UnBoxing(JDK5이상~)
	}
	public static void main(String[] args) 
	{
		Boxing box = new Boxing();
		box.m1();
		box.m2();
	}
}
