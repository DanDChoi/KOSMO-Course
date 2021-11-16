import java.io.*;

class OneTo100 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void input(){
		try{
			String line = br.readLine();
			int i = Integer.parseInt(line);
			if(i<0){
				System.out.println("점수는 음수가 될 순 없음");
				input();
			}else if(i>100){
				System.out.println("점수는 100이 넘을 수 없음");
				input();
			}else{
				System.out.println("정상적인 점수 i : " +i);
			}
		}catch(Exception e){}
	}
	public static void main(String[] args) 
	{
		new OneTo100().input();
	}
}
