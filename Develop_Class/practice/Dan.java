class Dan{
    String dan = "Dan";
    
    void danShow(){
        System.out.println(dan);
    }
    
	void changeName(){
		String john = "John";
		this.dan = john;

		System.out.println(dan);
	}

	
    public static void main(String[] args){
		Dan d = new Dan();

		System.out.println(d.dan);
		d.danShow(); 

		System.out.println("========");
		
		d.changeName();
		
		System.out.println("=========");
		
		System.out.println(d.dan);
		d.danShow(); 
    }
}
 
