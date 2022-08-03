import java.net.*;
import java.io.*;
// run 한번에실행
//wello-known port : 0 ~ 1023 
class AServer extends Thread
{
   int port = 4000;
   ServerSocket ss; //mserver
   Socket s;      // msocket
   String ipClient;
   OutputStream os;
   DataOutputStream dos;
   //BufferedReader in;
   //PrintWriter out;
   InputStream is; //node 
   DataInputStream dis; //filter 
   AServer(){
      try{
         ss = new ServerSocket(port);
         pln(port+"번 포트에서 서버 대기중...");
   
         s = ss.accept();
         ipClient = s.getInetAddress().getHostAddress();
         pln("클라이언트("+ipClient+")입장!!");      
         is = s.getInputStream();
         os = s.getOutputStream();
         start();
         speak();      
      }catch(IOException ie){
         pln("ie: " + ie);
      }finally{
         try{
            if(s != null) s.close();
            if(ss != null) s.close();
         }catch(IOException ie){}
      }
   }
   public void run(){
      listen();
   }
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   void speak(){ //keyboard -> socket 
      dos = new DataOutputStream(os);
      try{
         String msg = "";
         while(true){
            msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
         }
      }catch(IOException ie){
         pln("서버가 다운됨.. 2초 후에 종료하겠습니다");
         try{
            Thread.sleep(2000);
         }catch(InterruptedException iee){}
         System.exit(0);
      }finally{
         try{
            if(dos != null) dos.close();
            if(os != null) os.close();
         }catch(IOException ie){}
      }
   }

   void listen (){ //socket -> monitor 
      dis = new DataInputStream(is);
      try{
         while(true){
            String msg = dis.readUTF();
            pln("client("+ipClient+")>> " + msg);
         }
      }catch(IOException ie){
         pln("클라이언트("+ipClient+")퇴장!!");
      }finally{
         try{
            if(dis != null) dis.close();
            if(is != null) is.close();
         }catch(IOException ie){}
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