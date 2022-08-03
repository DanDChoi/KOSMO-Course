import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class FClient{ //file -> socket
    Socket s;
    String ip = "115.91.81.106"; //비대면
    //String ip = "192.168.0.63"; //본인 
    int port = 3500;
    String path = "/Users/Dan/Downloads/img.jpeg";
    
    FileInputStream fis;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    OutputStream os;

    FClient(){
        try{
            s = new Socket(ip, port);
            makeStream();
            send();
        }catch(UnknownHostException ne){
        }catch(IOException ie){
        }finally{
            try{
            if (s != null) s.close();
        }catch(IOException ie){
        }
         }
    }

    void makeStream(){
        try{
            fis = new FileInputStream(path);
            bis = new BufferedInputStream(fis, 2048);
            os = s.getOutputStream();
            bos = new BufferedOutputStream(os, 2048);
        }catch(FileNotFoundException fe){
        }catch(IOException ie){
        }
    }
    void send(){ //file -> socket
        int i = 0;
        long totalSize = 0L;
        byte bs[] = new byte[512];
        try {
            while ((i = bis.read(bs)) != -1) {
                bos.write(bs, 0, i);
                totalSize += i;
                pln("보내는중.."+totalSize+"bytes");
            }
            bos.flush();
            pln("파일 전송 완료 (" + totalSize + "bytes)");
        } catch (IOException ie) {
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (fis != null)
                    fis.close();
                if (bos != null)
                    bos.close();
                if (os != null)
                    os.close();
            } catch (IOException ie) {
            }
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }
    public static void main(String[] args){
        new FClient();
    }
}