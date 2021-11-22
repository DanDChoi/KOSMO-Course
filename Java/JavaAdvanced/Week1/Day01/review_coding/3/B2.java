import java.io.*;

class B2{
    InputStream is = System.in;
    OutputStream os;
    B2(){
        try{
            os = new FileOutputStream("b.txt");
        }catch(FileNotFoundException fe){
        }
    }
    void in1(){
        try{
            int i = 0;
            while((i=is.read()) != -1){
                os.write(i);
                if(i==13){
                    break;
                }
            }
            os.flush();
        }catch(IOException ie){
		}
	}
	void in2(){
		byte bs []= new byte[2];
		int i = 0;
		try{
			
			while((bs[i]=(byte)is.read()) != -1){
				os.write(bs);
				if(i==13){
					break;
				}
			}
			os.flush();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	} 

	void in3() { 
            byte[] bs = new byte[8]; 
			try{
				int i = 0;
				while ((i=is.read(bs)) != -1){
					os.write(bs, 0, i);
				}
				os.flush();
        } catch (IOException ie) {
        } finally{
			try{
				is.close();
				os.close();
			}catch(IOException ie){}
		}
   }
	public static void main(String[] args) 
	{
		B2 b2 = new B2();
		b2.in1();
		b2.in2();
		b2.in3();
	}
}
