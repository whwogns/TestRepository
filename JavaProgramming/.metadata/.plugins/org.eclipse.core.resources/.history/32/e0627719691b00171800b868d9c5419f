package ch12.exam10;

public class PrintThread1 extends Thread {   //플래그를 이용하는 방법
	
	
	//Field
	private boolean stop;
	//Constructor
	//Method
	public void run(){
		while(!stop){  // 실행흐름을 바꾸는 것을 플래그라고 함. 여기선 stop변수를 프래그라함.
		System.out.println("실행중...");
		System.out.println("실행중...");
		}
		System.out.println("자원정리");
		System.out.println("실행종료");
				
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
