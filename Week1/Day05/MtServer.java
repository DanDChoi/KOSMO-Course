import java.io.*;
import java.net.*;
import java.util.Vector;

class MtServer {
    ServerSocket ss;
    Socket s;
    int port = 3000;
    OneCliMod ocm = null;
    Vector<OneCliMod> v = new Vector<OneCliMod>();

    MtServer() {
        try {
            ss = new ServerSocket(port);
            pln(port + "번 포트에서 멀티서버 대기중..");
            while (true) {
                s = ss.accept();
                ocm = new OneCliMod(this);
                v.add(ocm);
                ocm.start();
            }
        } catch (IOException ie) { // 다른곳에서 포트를 사용중일때 일어날 수 있는 exception
            pln(port + "번 포트는 이미 사용중임");
        } finally {
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException ie) {
            }
        }
    }


    void p(String str) {
        System.out.print(str);
    }

    void pln(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        MtServer ms = new MtServer();
    }

}