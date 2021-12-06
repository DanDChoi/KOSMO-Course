
import java.io.*;
import java.net.*;

public class Ct{
    private Socket cs;
    private DataInputStream in;
    private DataOutputStream out;
    private Cgui cgui;
    private String msg;//클라이언트 GUI Textfield에서 보낸 메시지를 받기 위함

    private String nickName;//클라이언트 GUI 클래스의 main()콘솔에서 nickname을 받기 위함
    
    public final void setCgui(Cgui cgui){
        this.cgui = cgui;
    }

    public void connect(){
        try{
            cs = new Socket("127.0.0.1", 7777);
            in = new DataInputStream(cs.getInputStream());
            out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF(nickName);
                //클라이언트 GUI의 main()메서드로부터 받은 메시지를 백그라운드서버의 내부 Receiver클래스의
                //생성자로 보냄, 거기서 처음 한 번 읽음
            while(in != null){
                //각각의 클라이언트마다 계속 대기하고 있다가 서버 백그라운드의 sendMessage()메서드에서
                //보낸 메시지 읽어서 자신의 GUI화면에 띄움
                msg = in.readUTF();
                cgui.appendMsg(msg);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void sendMessage(String msg2){
        //클라이언트GUI클래스의 TextField로부터 받은 메시지를 서버백그라운드 클래스 안의
        //내부 Receiver클래스 안의 run()메서드 안에 while문으로 보냄
        try{
            out.writeUTF(msg2);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
}