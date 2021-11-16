class OperT 
{
	// + , - , * , / , % 
	void m1(){
		int j = 100; //Á¡¼ö1
		int k = 100; //Á¡¼ö2

		int t = j + k; //ÃÑÁ¡ 
        int a = t/2; //Æò±Õ
	    String grade = m2(a); //ÇÐÁ¡
		System.out.println("ÃÑÁ¡: " + t + ", Æò±Õ: "+a + ", ÇÐÁ¡: " + grade);
	}
	String m2(int a){
		if(a>=90) return "A";
		else if(a>=80) return "B";
		else if(a>=70) return "C";
		else if(a>=60) return "D";
		else return "F";
	}
	public static void main(String[] args) {
		OperT op = new OperT();
		op.m1();
	}
}
