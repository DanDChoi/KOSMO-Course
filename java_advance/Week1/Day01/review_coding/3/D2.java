import java.io.*;

class D2
{
	String fname = "경로";
	FileInputStream fis; 
	OutputStream os = System.out;
	FileOutputStream fos; 
	String fcopy = "COPY.jpg";

	BufferedInputStream bis;
	BufferedOutputStream bos; 


	D2(){
		try{
			fis = new FileInputStream(fname);
			bis = new BufferedInputStream(fis, 4096);
			fos = new FileOutputStream(fcopy);
			bos = new BufferedOutputStream(fos, 4096);
		}catch(FileNotFoundException fe){
			System.out.println(fname+"이란 파일을 못찾음");
		}
	}
	
	void copy(){
		byte bs[] = new byte[1024];  
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				total += i;
			}
			bos.flush();

			System.out.println("복사("+fcopy+") 완료("+total+")bytes!!");
		}catch(IOException ie){
		}finally{
			try{
				bis.close();
				bos.close();
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
	}
	public static void main(String[] args) 
	{
		D2 d2 = new D2();
		d2.copy();
	}
}