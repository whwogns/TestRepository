package ch14.exam01;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();//����ƽ�̶� ���� �̿��ص� ������ ��ü���̵� ���ٰ��� ��
		
		for(int i=0;i<5;i++){
			toolkit.beep();
			try{
			Thread.sleep(500);//õ���� 1�ʷ� �޽�
			}catch(InterruptedException e){
				
			}
		}
	}

}
