import java.io.*;

class Input2 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void input(){
		System.out.print("����: ");
		try{
			String line = br.readLine();
			int jumsu = Integer.parseInt(line);
			System.out.println("jumsu: " + (jumsu + 1));
		}catch(IOException ie){
		}
	}
	void input(String subject){
		System.out.print(subject+": ");
		try{
			String line = br.readLine();
			int jumsu = Integer.parseInt(line);
			System.out.println("�Էµ� "+subject+": " + jumsu);
		}catch(IOException ie){
		}
	} 
	public static void main(String[] args) 
	{
		Input2 ip = new Input2();
		//ip.input();

		String subjects[] = {"����", "����", "����"};
		for(int i=0; i<subjects.length; i++){
			ip.input(subjects[i]);
		}
	}
}
