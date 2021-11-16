class Body {
	String part;
	Body(){
		part = "등";
	}
	Body(String part){
		this.part = part;
	}
	void Proud(){
		System.out.println(part + "근육을 자랑스러워 한다");
	}
}

class Trainer {
	String sex;
	Body muscle1,muscle2;
	int age;
	Trainer(){
		sex = "여자";
		age = 25;
	}
	Trainer(String sex, int age){
		this.sex = sex;
		this.age = age;
	}
	void Trainning(){
		System.out.println("운동을 시킨다");
	}
	void Care(){
		System.out.println("식단을 관리한다");
	}
	void Exercise(){
		muscle1 = new Body("가슴");
		muscle2 = new Body("어깨");
		System.out.println("트레이너가 "+ muscle1.part +"근육 운동을 한다");
	}
}

class Customer {
	String Csex;
	int weight;
	Customer(){
		Csex = "여자";
		weight = 40;
	}
	Customer(String Csex, int weight){
		this.Csex = Csex;
		this.weight = weight;
	}
	void Minus(){
		System.out.println("살을 뺀다");
	}
}

class Gym	
{
	public static void main(String[] args) 
	{
		Trainer tra = new Trainer();
		System.out.print("성별이 " + tra.sex +"이고 나이가 " + tra.age + "살인 트레이너가 ");
		tra.Trainning();

		Trainer tra1 = new Trainer("남자",28);
		System.out.print("성별이 " + tra1.sex +"이고 나이가 " + tra1.age + "살인 트레이너가 ");
		tra.Care();
		
		Body b = new Body();
		System.out.print("성별이 " + tra1.sex +"이고 나이가 " + tra1.age + "살인 트레이너가 " + b.part + "근육을 ");
		b.Proud();

		tra.Exercise();

		Customer cus = new Customer();
		System.out.print("성별이 " + cus.Csex + "이고 몸무게가 " + cus.weight + "kg인 고객이 ");
		cus.Minus();
		Customer cus1 = new Customer("남자",75);
		System.out.print("성별이 " + cus1.Csex + "이고 몸무게가 " + cus1.weight + "kg인 고객이 ");
		cus.Minus();

		System.out.print("트네이너는 ");
		tra.muscle1.Proud();

	}
}
