package ch14.exam01;

import java.awt.Toolkit;

public class BeepTask implements Runnable{
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

}
