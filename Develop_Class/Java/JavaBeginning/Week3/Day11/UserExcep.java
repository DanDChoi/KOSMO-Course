class MyException extends Exception {
	void use(){
		System.out.println("MyException use()");
	}
}
class YourException extends Exception {
	void apply(){
		System.out.println("YourException apply()");
	}
}
