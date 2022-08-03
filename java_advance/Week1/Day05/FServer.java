import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

class FServer { // socket -> file
    ServerSocket ss;
    Socket s;
    int port = 3500;
    String ipClient;
    InputStream is;
    BufferedInputStream bis;
    BufferedOutputStream bos;
    String fName = "";
    FileOutputStream fos;
    FileInputStream fis;

    FServer() {
        try {
            ss = new ServerSocket(port);
            pln(port + "번 포트에서 파일서버 대기중");
            s = ss.accept();
            ipClient = s.getInetAddress().getHostAddress();
            pln("Client(" + ipClient + ") connected");

            makeStream();
            receive();
        } catch (IOException ie) {
        } finally{
            try{
                if(s != null) s.close();
                if(ss != null) ss.close();
            }catch(){}
        }
    }

    void makeStream() {
        try {
            is = s.getInputStream();
            bis = new BufferedInputStream(is, 2048);
            File dir = new File("Store");
            if(!dir.exists()) dir.mkdir();
            fos = new FileOutputStream(dir+"/"+fName);
            bos = new BufferedOutputStream(fos, 2048);

        } catch (IOException ie) {
        }
    }

    void receive() { // socket -> file
        int i = 0;
        long totalSize = 0L;
        byte bs[] = new byte[512];
        try {
            while ((i = bis.read(bs)) != -1) {
                bos.write(bs, 0, i);
                totalSize += i;
                pln("받는중.."+totalSize+"bytes");
            }
            bos.flush();
            pln("파일(" + fName + ") 받기 완료 (" + totalSize + "bytes)");
        } catch (IOException ie) {
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
            }
        }
    }

    void pln(String str) {
        System.out.println(str);
    }

    void p(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        new FServer();
    }
}