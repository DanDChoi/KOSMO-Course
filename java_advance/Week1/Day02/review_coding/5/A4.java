import java.io.*;

class A4{
    String fName = "A.java";
    OutputStream os = System.out;
    Reader r;
    Writer w;

    FileWriter fw;

    a4(){
        try{
            r = new FileReader(fName);
            w = new OutputStreamWriter(os);
            fw = new FileWriter("A.txt");
        }catch(FileNotFoundException fe){
            System.out.println(fName+"이란 파일이 없음");
        }catch(IOException ie){
        }
    }
    void rw(){
        int i = 0;
        char ch[] = new char[8];
        try{
            while((i=r.read(ch)) != -1){
                w.write(ch, 0, i);
                fw.write(ch, 0, i);
            }
            w.flush();
            fw.flush();
        }catch(IOException ie){
        }finally{
            try{
                fw.close();
                w.close();
                os.close();
                r.close();
            }catch(IOException ie){}
        }
    }

    public static void main(String[] args){
        A4 a = new A4();
        a4.rw();
    }
}