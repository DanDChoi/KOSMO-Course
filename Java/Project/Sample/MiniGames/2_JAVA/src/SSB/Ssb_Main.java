package SSB;


public class Ssb_Main {
	public Ssb_Main() {
		Ssb_Nick_Gui gui = new Ssb_Nick_Gui();  //닉네임 설정 화면 띄우기 
		gui.setSonagi_main(this);
	}
	
	// 닉네임 클래스 , 닉네임 가지고 showGameView 메소드 실행 
	public void showGameView(Ssb_Nick_Gui gui ,String nick, int lev){
		gui.dispose();//닉네임 화면 없애기
		Ssb_GameView game = new Ssb_GameView(nick, lev);// 닉네임 가지고 게임화면 띄우기 
	}
}
