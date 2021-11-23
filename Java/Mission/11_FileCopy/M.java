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
    String fname = "";
    String str, fcopy = "";
    String filePath;
    Scanner scan = new Scanner(System.in);
    String dirName;
    
    M(){

    }
    

    public void input(){
        try{
            ps.println("1. 복사   2.잘라내기");
            String str = scan.next();
            int i = Integer.parseInt(str);
            if(i==1) {
               in();
            }else if(i==2){
               inCut();
            }else {
               System.out.println("1 또는 2를 입력해주세요");
            }
            }catch(NumberFormatException ime){
                System.out.println("1 또는 2를 입력해주세요");
                input();
        }
        
    }
    public void fCopy(){
        String destination = dirName + "\\" + fcopy;
        try{
            this.fos = new FileOutputStream(destination);
            this.bos = new BufferedOutputStream(this.fos, 4096);
        }catch(IOException ie){
        }
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
        int i = add.lastIndexOf("\\");
      fcopy = add.substring(i+1);
        //System.out.println("i: " + i);
        //System.out.println("add:" +add);
        try{
            fis = new FileInputStream(add); 
            bis = new BufferedInputStream(fis, 4096);
            }catch(FileNotFoundException fnfe){ 
                System.out.println(fname+" 이라는 파일이 없습니다.");
                in();
            }
        creatD();
        
    }

    public void inCut(){
        
        ps.println("잘라낼 파일의 경로를 입력하세요");
        String add = scan.next();
        fname = add;
        int i = add.lastIndexOf("\\");
      fcopy = add.substring(i+1);
        //System.out.println("i: " + i);
        //System.out.println("add:" +add);
        try{
            fis = new FileInputStream(add); 
            bis = new BufferedInputStream(fis, 4096);
            }catch(FileNotFoundException fnfe){ 
                System.out.println(fname+" 이라는 파일이 없습니다.");
                in();
            }
        creatDCut();
        
    }
    
    
    public void fCut() {
        String destination = dirName + "\\" + fcopy;
        try{
            this.fos = new FileOutputStream(destination);
            this.bos = new BufferedOutputStream(this.fos, 4096);
        }catch(IOException ie){
        }
        System.out.println("1");
        byte bs[] = new byte[1024];
        System.out.println("2");
        try {
            int i = 0;
            long total = 0L;
            while ((i = bis.read(bs)) != -1) {
                bos.write(bs, 0, i);
                total += i;
            }
            bos.flush();
            System.out.println("잘라내기(" + fcopy + ") 완료(" + total + ")bytes!!");
        } catch (IOException ie) {
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
        del();
    }

    void creatD() {
        System.out.println("디렉토리 생성합니다. 디렉토리를 생성할 경로를 입력하세요.");
        this.dirName = scan.next();
        File f = new File(dirName);
        if (f.exists()) {
            System.out.println("존재함, 파일을 복사합니다.");
            fCopy();
        } else {
            System.out.println("존재하지않음, 새 디렉토리를 만듭니다.");
            f.mkdirs();
            fCopy();
        }
    }

    void creatDCut() {
        System.out.println("디렉토리 생성합니다. 디렉토리를 생성할 경로를 입력하세요.");
        this.dirName = scan.next();
        File f = new File(dirName);
        if (f.exists()) {
            System.out.println("존재함, 파일을 복사합니다.");
        } else {
            System.out.println("존재하지않음, 새 디렉토리를 만듭니다.");
            f.mkdirs();
        }
        fCut();
    }

    void del(){
        File f = new File(fname);
      f.delete();
    }

    public static void main(String[] args){
        M m = new M();
        m.input();
    }
}