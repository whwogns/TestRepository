package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//�Ҹ��� ���� �ڵ�
		/*BeepTask beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);//���ο� �½�ũ�� �����Ͽ� ������ �����ϰԲ� �ϴ°���.
		thread.start();*/
		
		Thread thread = new Thread(new Runnable(){   //��ȣ���� �۾���ü�� �����Ѵ�.  ��ȣ ���� ���ν����尡 �����Ѵ�. 
			/// �� ���ν����尡 ����Ʈ �ڵ� ������ ���� �۾������尡 ���ÿ� �Ҹ��ڵ带 ����.
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
		});
		System.out.println(thread.currentThread().getName());
		thread.start();
		
		
		//����Ʈ�� �ϴ� �ڵ�
		for(int i=0;i<5;i++){
			System.out.println("��");
			try{
				Thread.sleep(500);//õ���� 1�ʷ� �޽�
				}catch(InterruptedException e){
					
				}
		
		}
		
	}
}
//������ Ŭ�����κ��� �۾���ü�� �����.