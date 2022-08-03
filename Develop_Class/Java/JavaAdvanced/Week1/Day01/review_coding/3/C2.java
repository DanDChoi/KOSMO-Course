import java.io.*;

class C2 {
    String fname = "경로";
    FileInputStream fis; 
    PrintStream os = System.out; 
    FileOutputStream fos; 
    String fcopy = "copy.txt";

    C2(){
        try{
       fis = new FileInputStream(fname);
       fos = new FileOutputStream(fcopy);
        }catch(FileNotFoundException fe){
            System.out.println(fname+"이란 파일을 찾을 수 없습니다.");
        }
    }

    void r1(){
        byte[] bs = new byte[8];
			try{
				int i = 0;
				while ((i=fis.read(bs)) != -1){
					os.write(bs, 0, i);
				}
				os.flush();
        } catch (IOException ie) {
        } finally{
			try{
				fis.close();
				os.close();
			}catch(IOException ie){}
		}
    }

    void r2(){
        byte[] bs = new byte[8];
			try{
				int i = 0;
				while ((i=fis.read(bs)) != -1){
					fos.write(bs, 0, i);
				}
				fos.flush();
        } catch (IOException ie) {
        } finally{
			try{
				fis.close();
				fos.close();
			}catch(IOException ie){}
		}
        System.out.println("copy completed :" + fcopy);
    }

    public static void main(String[] args){
        C2 c2 = new C2();
        c2.r1();
        c2.r2();
    }

}