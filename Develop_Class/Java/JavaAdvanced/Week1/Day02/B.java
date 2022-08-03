import java.io.*;

//Keyboard  -> File 
class B {
	InputStream is = System.in; //Node 
	InputStreamReader isr = new InputStreamReader(is); //Bridge 
	BufferedReader br = new BufferedReader(isr); //Filter 

	FileWriter fw; //Node 
	PrintWriter pw; //Filter : autoFlush, many method, bridge X 

	B(){
		try{
			fw = new FileWriter("B.txt");
			pw = new PrintWriter(fw, true);
		}catch(IOException ie){
		}
	}
	void rw(){
		String line = "";
		try{
			while((line = br.readLine()) != null){	
				pw.println(line);
			}
		}catch(IOException ie){
		}finally{
			try{
				if(pw != null) pw.close();
				if(fw != null) fw.close();
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) {
		B b = new B();
		b.rw();
	}
}
