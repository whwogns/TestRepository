package ch14.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//�Ҹ��� ���� �ڵ�
		
		
		Thread thread = new Thread(()->{ 
			
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i=0;i<5;i++){
					toolkit.beep();
					try{
					Thread.sleep(500);//õ���� 1�ʷ� �޽�
					}catch(InterruptedException e){
						
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