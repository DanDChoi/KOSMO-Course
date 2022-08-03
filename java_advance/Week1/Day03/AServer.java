import java.net.*;
import java.io.*;

public class AServer implements Runnable {
	int port = 4000; //well-known port : 0 ~ 1023 
	ServerSocket ss;
	Socket s;
	String ipClient;
	String in = "", out = "";

	BufferedReader br1, br2;
	PrintWriter pw1;
	Thread t1, t2;

	InputStream is;
	DataInputStream dis;

	public AServer() {
		try {
			t1 = new Thread(this);
			t2 = new Thread(this);
			ss = new ServerSocket(port);

			pln(port + "번 포트에서 서버 대기중...");
			s = ss.accept();

			ipClient = s.getInetAddress().getHostAddress();

			pln("클라이언트(" + ipClient + ")입장");

			t1.start();
			t2.start();

			//is = s.getInputStream();
			//listen();
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
/*
	void listen() { // socket -> monitor
		dis = new DataInputStream(is);
		try {
			while (true) {
				String msg = dis.readUTF();
				pln("client(" + ipClient + "): " + msg);
			}
		} catch (IOException ie) {
				pln("클라이언트(" + ipClient + ")퇴장");
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
*/
	public void run(){
		try{
		if(Thread.currentThread() == t1){
			do{
				br1 = new BufferedReader(new InputStreamReader(System.in));
				pw1 = new PrintWriter(s.getOutputStream(), true);
				in = br1.readLine();
				pw1.println(in);
			}while(!in.equals("END"));
		}else{
			do{
				br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = br2.readLine();
				pln("Client says: " + out);
			}while(!out.equals("END"));
		}
		}catch(IOException ie){
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
