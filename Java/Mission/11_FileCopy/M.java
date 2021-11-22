import java.io.*;
import java.util.Scanner;

public class M{
    FileInputStream fis;
    FileOutputStream fos;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    InputStream is = System.in;
    Reader r = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(r);
    PrintStream ps = System.out;
    OutputStream os = System.out;
    
    M(){
       
    }
    
    String fname, str;
    String fco;
    Scanner scan = new Scanner(System.in);
    void input(){
        ps.println("1. 복사   2.잘라내기");
        int i = scan.nextInt();
        if(i == 1){
            fCopy();
        }else{
            //fCut();
        }
    }

    void in(){
        ps.println("복사할 파일의 경로를 입력하세요");
        String add = scan.next();
        fname = add;
        try{
            fis = new FileInputStream(fname);
            fos = new FileOutputStream(fco);
            bis = new BufferedInputStream(fis, 4096);
            bos = new BufferedOutputStream(fos, 4096);
            }catch(FileNotFoundException fnfe){ 
                System.out.println("파일이 없습니다.");
            }
            getFname(add,fco);
    }
    String getFname(String add, String fco){
		int i = add.lastIndexOf("/");
		System.out.println("i: " + i);
		String str = add.substring(i+1);
		System.out.println("파일이름: " + str);
        fco = str;
        return fco;
	}

    void fCopy(){
        in();
        byte bs[] = new byte[1024];  
		try{
			int i = 0;
			long total = 0L;
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				total += i;
			}
			bos.flush();

			System.out.println("복사("+fco+") 완료("+total+")bytes!!");
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
    
    /*
    void fCut(){

    }


    void output(){

    }

    void creatD(){
        File f = new File(str);
		if(f.exists()){
			System.out.println("존재함");
		}else{
			System.out.println("존재하지않음.. 만들까요(y/n)?");
			f.mkdirs();
		}
    }

    void del(){
        File f = new File(str);
		f.delete();
    }
    
    void getFname(){
        int i = str.lastIndexOf("\\");
		System.out.println("i: " + i);
		String fname = str.substring(i+1);
		System.out.println("파일이름: " + fname);
    } */


    public static void main(String[] args){
        M m = new M();
        m.input();
    }
}