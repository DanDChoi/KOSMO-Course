
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sv {
   private ServerSocket ss;
   private Socket cs;
   private Sgui sg; // 서버 GUI와 통신하기 위함
   private String msg;

   private DataInputStream in;
   private DataOutputStream out;
   private String nick;

   private Map<String, DataOutputStream>clientMap = Collections.synchronizedMap(new HashMap<String, DataOutputStream>());
   // 각각의 클라이언트에게 메세지가 누락되지 않고 중복하여 보내지지 않도록..
   public final void setSg(Sgui sg) {
      this.sg = sg;
   }

   public void setting() throws IOException { // 서버GUI에서 구동시킴
      try {
         ss = new ServerSocket(7777);
         while (true) { // 계속 새로운 클라이언트를 받기 위한 while문
            cs = ss.accept();
            // 클라이언트 접속을 대기하고 있다가, 접속이 확인되면,
            // 새로운 클라이언트 소켓을 만들어주고, while문에 의해 또 계속 대기,
            // 이 과정을 main스레드에서 반복함.
            Thread receiver = new Receiver(cs);
            receiver.start();
            // 원래 목적은 새로운 스레드를 만들어 한 클라이언트와 대화 작업을 run()에 넘기려 했으나
            // 생성하면서 nickname도 받는 작업까지 함
            // 1) 먼저 Receiver(cs)생성자에서 nickname(Map의key)을 클라이언트 GUI main()
            // 메서드의 콘솔로부터 입력한 nickname을 받고,
            // 2)새로운 클라이언트가 들어오면 (receiver이름 객체는 새롭게 들어오면 자동으로 만들어짐)
            // 새롭게 Receiver 클래스를 생성하여,run()으로 작업을 넘김
            // 3)새롭게 열린 소켓을 새로운 run()메서드에게 넘기고, sendMessage()로 각각의 클라이언트에게 보내고,
            // 받은 메시지를 자신의 GUI화면에 올리고(sg.appendMsg(msg)),
            // 클라이언트가 나가면 catch절의 removeClient(msg)에서 나간거 알리고, Map에서 지운다.
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void addClient(String nick, DataOutputStream out) throws IOException {
      sendMessage(nick + "was Connecting just now! \n");
      // 일단 각각의 클라이언트에게 새롭게 들어온거 알리고,
      clientMap.put(nick, out);
      // nick(key(nickname))과 out(값(메시지))을 Map에 입력시킴
      // 여기의 out 메시지는 공백이다.
   }

   public void removeClient(String nick) { // 내부클래스 Receiver의 run()메서드의 catch절에서 call한다
      sendMessage(nick + "is gone!\n");
      clientMap.remove(nick);
   }

   public void sendMessage(String msg) { // 클라이언트가 있으면 보내고 없으면 안보냄
      Iterator<String> it = clientMap.keySet().iterator();
      String key = "";

      while (it.hasNext()) {
         key = it.next();
         try {
            clientMap.get(key).writeUTF(msg);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   // -------내부클래스------
   class Receiver extends Thread {
      public Receiver(Socket cs) throws IOException {
         // 클라이언트 백그라운드 클래스의 connect()메서드의
         // out.writeUTF(nickName);으로 받은 메시지를 HashMap에 입력한다. value인 out은 공백으로 입력함.
         in = new DataInputStream(cs.getInputStream());
         out = new DataOutputStream(cs.getOutputStream());
         nick = in.readUTF();
         addClient(nick, out);// out은 공백으로 넣는다
      }

      @Override
      public void run() {
         // run()에서는 각각의 클라이언트의 메시지를 받고, sendMessage()로 각각의 클라이언트에게 보내고,
         // 받은 메시지를 자신의 GUI화면에 올리고(sg.appendMsg(msg)),
         // 클라이언트가 나가면 catch절의 removeClient(msg)에서 나간거 알리고, Map에서 지운다.
         try {
            while (in != null) { // 계속 읽기 대기
               msg = in.readUTF();
               sendMessage(msg);
               sg.appendMsg(msg);
            }
         } catch (Exception e) {
            removeClient(nick); // 클라이언트가 나가면 예외 발생함
         }
      }
   }
}