package SSB;

import javax.swing.JLabel;

public class TotalPlayTime extends Thread { // ���ӽð��� �����ϴ� Ŭ����, ������Ŭ������ ��ӹ���
	public int gamePlayTime; // ������ ���ӽð� ����
	public JLabel playTime = new JLabel("0"); // �ʱⰪ�� 0���� �Ѵ�

	public void run() {
		for (gamePlayTime = 0;; gamePlayTime++) {
			try {
				Thread.sleep(1000); // 1�ʿ� �ѹ��� gamePlayTime ������ ������Ų��
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
			playTime.setText(minute+ ":"+second); // playTime���̺��� gamePlayTime������
													// �����Ѵ�
		}
	}
}
