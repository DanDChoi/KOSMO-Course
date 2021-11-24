import java.net.*;
import java.io.*;

//wello-known port : 0 ~ 1023 
class AServer  
{
	int port = 4000;
	ServerSocket ss;
	Socket s;
	String ipClient;
	AServer(){
		try{
			ss = new ServerSocket(port);
			pln(port+"번 포트에서 서버 대기중...");
			s = ss.accept();
			ipClient = s.getInetAddress().getHostAddress();
			pln("클라이언트("+ipClient+")접속 성공!!");
		}catch(IOException ie){
			pln("ie: " + ie);
		}
	}
	void p(String str){
		System.out.print(str);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new AServer();
	}
}
