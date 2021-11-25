
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WThread extends Thread { // 서버로 메세지 보내는 Thread
	Socket socket = null;
	Scanner scanner = new Scanner(System.in); // 채팅용 Scanner
	
	public WThread(Socket socket) { // 생성자
		this.socket = socket; // 받아온 Socket Parameter를 해당 클래스 Socket에 넣기
	}
	
	public void run() {
		try {
			OutputStream out = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(out, true);
			
			while(true) { // 무한반복
				writer.println(scanner.nextLine()); // 입력한 메세지 발송
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
