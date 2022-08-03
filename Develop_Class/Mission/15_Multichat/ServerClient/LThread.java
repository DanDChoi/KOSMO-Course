
import java.io.*;
import java.net.*;

public class LThread extends Thread { // 서버에서 보낸 메세지 읽는 Thread
	Socket socket = null;

	public LThread(Socket socket) { // 생성자
		this.socket = socket; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
	}
	
	public void run() {
		try {
	
			InputStream input = socket.getInputStream(); // socket의 InputStream 정보를 InputStream in에 넣은 뒤
			BufferedReader reader = new BufferedReader(new InputStreamReader(input)); // BufferedReader에 위 InputStream을 담아 사용
			
			while(true) { // 무한반복
				System.out.println(reader.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
