package SSB;


public class Ssb_Main {
	public Ssb_Main() {
		Ssb_Nick_Gui gui = new Ssb_Nick_Gui();  //�г��� ���� ȭ�� ���� 
		gui.setSonagi_main(this);
	}
	
	// �г��� Ŭ���� , �г��� ������ showGameView �޼ҵ� ���� 
	public void showGameView(Ssb_Nick_Gui gui ,String nick, int lev){
		gui.dispose();//�г��� ȭ�� ���ֱ�
		Ssb_GameView game = new Ssb_GameView(nick, lev);// �г��� ������ ����ȭ�� ���� 
	}
}
