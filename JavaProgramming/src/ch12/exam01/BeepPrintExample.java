package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		//소리를 내는 코드
		/*BeepTask beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);//새로운 태스크를 생성하여 별도로 실행하게끔 하는것임.
		thread.start();*/
		
		Thread thread = new Thread(new Runnable(){   //괄호안은 작업객체가 실행한다.  괄호 밖은 메인스레드가 실행한다. 
			/// 즉 메인스레드가 프린트 코드 실행할 동안 작업스레드가 동시에 소리코드를 실행.
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();//스태틱이라 뉴를 이용해도 되지만 객체없이도 접근가능 또
				
				for(int i=0;i<5;i++){
					toolkit.beep();
					try{
					Thread.sleep(500);//천분의 1초로 휴식
					}catch(InterruptedException e){
						
					}
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