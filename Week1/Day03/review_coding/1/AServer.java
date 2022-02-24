import java.net.*;
import java.io.*;

class AServer {
    int port = 4000;
    ServerSocket ss;
    Socket s;
    String ipClient;
    InputStream is;
    DataInputStream dis;

    AServer() {
        try {
            ss = new ServerSocket(port);
            pln("Waiting for the clients on port number: " + port);

            s = ss.accept();
            ipClient = s.getInetAddress().getHostAddress();
            pln("Client(" + ipClient + ") has entered.");

            is = s.getInputStream();
            listen();
        } catch (IOException ie) {
            pln("ie: " + ie);
        } finally {
            try {
                if (s != null)
                    s.close();
                if (ss != null)
                    s.close();
            } catch (IOException ie) {
            }
        }
    }

    void listen() {
        dis = new DataInputStream(is);
        try {
            while (true) {
                String msg = dis.readUTF();
                pln("client(" + ipClient + "): " + msg);
            }
        } catch (IOException ie) {
            pln("client (" + ipClient + ") has left.");
        } finally {
            try {
                if (dis != null)
                    dis.close();
                if (is != null)
                    dis.close();
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
        new AServer();
    }
}