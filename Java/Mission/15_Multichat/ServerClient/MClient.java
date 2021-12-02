
import java.io.*;
import java.net.*;

public class MClient {
	public static void main(String[] args) {
		try {
			Socket socket = null;
			socket = new Socket("192.168.0.37", 4000); // 소켓 서버에 접속 
			System.out.println("서버에 접속 성공!"); // 접속 확인용
			
			LThread t1 = new LThread(socket); // 서버에서 보낸 메세지 읽는 Thread
			WThread t2 = new WThread(socket); // 서버로 메세지 보내는 Thread

			t1.start();
			t2.start();
            
		} catch (IOException e) {
			e.printStackTrace(); // 예외처리
		}
	}
}
