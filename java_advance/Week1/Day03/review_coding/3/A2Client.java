import java.net.*;
import java.io.*;

class A2Client {
    Socket s;
    String ip = "115.91.81.106";
    int port = 4000;
    OutputStream os;
    DataOutputStream dos;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    A2Client() {
        try {
            s = new Socket(ip, port);
            pln("Connected with " + ip);
            os = s.getOutputStream();
            speak();
        } catch (UnknownHostException ne) {
            pln("Can't find the server (" + ip + ").");
        } catch (IOException ie) {
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException ie) {
            }
        }
    }

    void speak() {
        dos = new DataOutputStream(os);
        String msg = "";
        try {
            while (true) {
                msg = br.readLine();
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException ie) {
            pln("Server has been closed. Process will be finished in 2 seconds.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException iee) {
            }
        } finally {
            try {
                if (dos != null)
                    dos.close();
                if (os != null)
                    dos.close();
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
        new A2Client();
    }

}