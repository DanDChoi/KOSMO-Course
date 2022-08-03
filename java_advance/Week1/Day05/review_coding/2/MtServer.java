import java.io.*;
import java.net.*;
import java.util.Vector;

class MtServer {
    ServerSocket ss;
    Socket s;
    int port = 3000;
    OneCliMod ocm;
    Vector<OneCliMod>  v= new Vector<OneCliMod>();
    
    MtServer(){
        try{
            ss = new ServerSocket(port);
            pln("Multi Server+"port"+ waiting for connecting");
            while (true) {
                s = ss.accept();
                ocm = new OneCliMod(this);
                v.add(ocm);
                ocm.start();
            }
        }catch(IOException ie){
            pln(port + " is already occupied.");
        } finally {
            try{
                if (ss != null) ss.close();
            }catch(IOException ie){
            }
        }
    }

    void p(String str){
        System.out.print(str);
    }
    void pln(String str){
        System.out.println(str);
    }
    public static void main(String[] args){
        MtServer ms = new MtServer();
    }
}