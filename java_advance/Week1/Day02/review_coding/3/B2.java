import java.io.*;


class B2 {
	InputStream is = System.in; 
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr); 

	FileWriter fw; 
	PrintWriter pw; 

	B2(){
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
		B2 b2 = new B2();
		b2.rw();
	}
}
