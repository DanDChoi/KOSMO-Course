interface QI{
	void m();
}
//방법1
/*class QIChild implements QI{
	public void m(){
		System.out.println("QIChild m()");
	}
}*/

class Q{
	public static void main(String[] args) {
		//방법1
		//QI qi = new QIChild();

		//방법2
		/*QI qi = new QI(){
			public void m(){
				System.out.println("QIChild m()");
			}
		};*/

		//방법3
		QI qi = () ->  System.out.println("QIChild m()");

		qi.m();
	}
}
