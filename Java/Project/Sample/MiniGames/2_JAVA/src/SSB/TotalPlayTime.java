package SSB;

import javax.swing.JLabel;

public class TotalPlayTime extends Thread { // 게임시간을 측정하는 클래스, 쓰레드클래스를 상속받음
	public int gamePlayTime; // 정수형 게임시간 변수
	public JLabel playTime = new JLabel("0"); // 초기값은 0으로 한다

	public void run() {
		for (gamePlayTime = 0;; gamePlayTime++) {
			try {
				Thread.sleep(1000); // 1초에 한번씩 gamePlayTime 변수를 증가시킨다
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String minute = ""+gamePlayTime / 60; 
			String second = ""+gamePlayTime % 60;
			if(minute.length() == 0) {
				minute = "00";
			} else if(minute.length() == 1){
				minute = "0"+minute;
			}
			if(second.length() == 0) {
				second = "00";
			} else if(second.length() == 1){
				second = "0"+second;
			}
			playTime.setText(minute+ ":"+second); // playTime레이블을 gamePlayTime변수로
													// 설정한다
		}
	}
}
