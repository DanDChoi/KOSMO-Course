class C {
	C() throws MyException {
		boolean flag = false;
		if(flag){
			throw new MyException();
		}
	}
	void m1() throws MyException {
		boolean flag = true;
		if(flag){
			throw new MyException();
		}
	}
}

class CUser{
	public static void main(String[] args) {
		try{
			C c = new C();
			System.out.println("���� �߻� ���� at C()");
			c.m1();
			System.out.println("���� �߻� ���� at m1()");
		}catch(MyException me){
			System.out.println("���� �߻� ��");
			me.use();
		}
	}
}
