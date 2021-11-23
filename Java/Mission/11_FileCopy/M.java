import java.io.*;
import java.util.InputMismatchException;
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
    String fname = "";
    String str, fcopy = "";
    String filePath;
    Scanner scan = new Scanner(System.in);
    
    M(){

    }
    

    public void input(){
        try{
            ps.println("1. 복사   2.잘라내기");
            int i = scan.nextInt();
            if(i == 1){
                fCopy();
            }else if(i == 2){
                fCut();
            }else{
                System.out.println("1 또는 2를 입력하세요");
                input();
            }
        }catch(InputMismatchException ime){
                System.out.println("1 또는 2를 입력하세요");
                input();
        }
        
    }
    public void fCopy(){
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
			System.out.println("복사("+fcopy+") 완료("+total+")bytes!!");
		}catch(IOException ie){
		}finally{
			try{
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			}catch(IOException ie){}
		}
    }

    public void in(){
        
        ps.println("복사할 파일의 경로를 입력하세요");
        String add = scan.next();
        fname = add;
        int i = add.lastIndexOf("/");
		fcopy = add.substring(i+1);
        //System.out.println("i: " + i);
        //System.out.println("add:" +add);
        try{
            fis = new FileInputStream(add);
            fos = new FileOutputStream(fcopy);
            bis = new BufferedInputStream(fis, 4096);
            bos = new BufferedOutputStream(fos, 4096);
            }catch(FileNotFoundException fnfe){ 
                System.out.println(fname+" 이라는 파일이 없습니다.");
                in();
            }
        
    }
    
    
    public void fCut(){
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
			System.out.println("복사("+fcopy+") 완료("+total+")bytes!!");
		}catch(IOException ie){
		}finally{
			try{
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			}catch(IOException ie){}
		}


    }
    
    void creatD(){
        System.out.println("디렉토리 생성합니다. 다시한번 경로를 입력해주세요.");
        String str = scan.next();
        File f = new File(fname);
        if (str != null)
            str = str.trim();
        if (str.equalsIgnoreCase("yes")) {
            if (f.mkdirs())
                fCopy(); // 디렉토리 생성
        } else {
            if (str.equalsIgnoreCase("no"))
                return;
        }
    }
    /*
    void del(){
        File f = new File(str);
		f.delete();
    }
    
    } */


    public static void main(String[] args){
        M m = new M();
        m.input();
    }
}