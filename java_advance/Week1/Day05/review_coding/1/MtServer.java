import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
            pln("Multi Server(port number:" + port + ") is waiting...");
            while (true) {
                s = ss.accept();
                ocm = new OneCliMod(this);
                v.add(ocm);
                ocm.start();
            }
        } catch (IOException ie) {
            pln(port + " is already occupied.");
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