import java.io.*;

//file -> moniter 
//file -> file
class D
{
	String fname = "/Users/Dan/Desktop/Develop/Develop_Class/Java/JavaAdvanced/Week1/Day01/IO.jpg";
	FileInputStream fis; //Node Stream : 파일
	OutputStream os = System.out; //Node Stream : 모니터 
	FileOutputStream fos; //Node Stream : 파일 
	String fcopy = "COPY.jpg";

	BufferedInputStream bis; //Filter 
	BufferedOutputStream bos; //Filter 


	D(){
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
		D d = new D();
		d.copy();
	}
}

