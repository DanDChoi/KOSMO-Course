class D {
	private void m(String name, int age){
		System.out.println("D�� m()");
	}
}
class DChild extends D {
	private void m(String name, int age){ 
		System.out.println("DChild�� m()");
	}
}
class DUser {
	public static void main(String[] args) {
		D d = new DChild();
		//d.m("�浿", 22);
	}
}
