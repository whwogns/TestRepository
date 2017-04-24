package ch12.exam07;

public class ThreadB extends Thread {

	
	//Field
	private boolean stop = false;//스레드를 종료하기 위한 목적
	private boolean work = true;//스레드 작업을 양보하기 위한 목적
	//Constructor
	//Method
	@Override
	public void run() {
		while(!stop){
			if(work){   // work가 false면 무의미한 반복만 할뿐 이것은 무의미한 대기일뿐이므로 이럴바에 다른 스레드를 돌리게끔하는게 낫다.  이를 양보라함.
			System.out.println("ThreadB 작업 중....");
			}else{
				yield();//해당 스레드가 빠지고 다른 스레드가 실행될수잇다.
				
			}
		}
		System.out.println("ThreadB작업 종료");
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setWork(boolean work) {
		this.work = work;
	}
}
