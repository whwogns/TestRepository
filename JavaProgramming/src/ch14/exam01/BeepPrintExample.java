package ch14.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//소리를 내는 코드
		
		
		Thread thread = new Thread(()->{ 
			
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i=0;i<5;i++){
					toolkit.beep();
					try{
					Thread.sleep(500);//천분의 1초로 휴식
					}catch(InterruptedException e){
						
					}
				}
			
		});
		System.out.println(thread.currentThread().getName());
		thread.start();
		
		
		//프린트를 하는 코드
		for(int i=0;i<5;i++){
			System.out.println("띵");
			try{
				Thread.sleep(500);//천분의 1초로 휴식
				}catch(InterruptedException e){
					
				}
		
		}
		
	}
}
//스레드 클래스로부터 작업객체를 만든것.