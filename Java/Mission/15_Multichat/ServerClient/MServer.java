
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class MServer extends Thread {
	static ArrayList<Socket> list = new ArrayList<Socket>(); // 유저 확인용
	static Socket socket = null;
	DataInputStream dis;
	InputStream is;

	public MServer(Socket socket) {
		MServer.socket = socket;
		list.add(socket);
	}

	public void run() { // Thread 에서 start() 메소드 사용 시 자동으로 해당 메소드 시작 (Thread별로 개별적 수행)
		try {
			System.out.println("서버 : " + socket.getInetAddress() + " IP의 클라이언트와 연결되었습니다");

			InputStream input = socket.getInputStream(); // 클라이언트에서 보낸 메세지 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(input));

			OutputStream out = socket.getOutputStream(); // 서버에서 클라이언트로 메세지 보내기
			PrintWriter writer = new PrintWriter(out, true); // true 자동 flush

			writer.println("서버에 연결되었습니다! ID를 입력해 주세요!"); // 클라이언트에게 연결되었다는 메세지 보내기

			String readValue; // Client 입력내용
			String name = null; // Client 이름
			boolean identify = false;

			while ((readValue = br.readLine()) != null) { // Client가 메세지 입력시 수행
				if (!identify) {
					name = readValue; // 이름 할당
					identify = true;
					writer.println(name + "님이 접속하셨습니다.");
					continue;
				}
				for (int i = 0; i < list.size(); i++) { // list 안에 클라이언트 정보가 담겨있음
					out = list.get(i).getOutputStream();
					writer = new PrintWriter(out, true);
					writer.println(name + " : " + readValue); // 클라이언트에게 메세지 발송
					System.out.println(name + " : " + readValue);
					LThread t1 = new LThread(socket); // 서버에서 보낸 메세지 읽는 Thread
					WThread t2 = new WThread(socket); // 서버로 메세지 보내는 Thread
					t1.start();
					t2.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			int socketPort = 4000;
			ServerSocket serverSocket = new ServerSocket(socketPort);
			System.out.println("socket : " + socketPort + "번 포트 서버 대기중입니다.");

			while (true) {
				Socket socketUser = serverSocket.accept(); // 대기중 ...
				Thread thd = new MServer(socketUser);
				thd.start();
			}
		} catch (IOException e) {
		}

	}

}
