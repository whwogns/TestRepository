package ch12.exam10;

public class InterruptExample {

	public static void main(String[] args) {
			
		//how2
		//interrupt는 스레드가 일시정지상태에 있을때만 영향을 받는다./ 실행중이면 이에 영향없다.
	
	
	PrintThread2 thread2 = new PrintThread2();
	thread2.start();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
	}
	thread2.interrupt();//일시정지일때 일시정지로 갈때만 인터럽트가 의미있다.
	}
}
