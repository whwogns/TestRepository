package ch12.exam03;

public class WorkThread extends Thread {
	//Field
	//Constructor
	WorkThread(String threadName){
		//super(threadName);
		setName(threadName); //이렇게도 스레드 이름을 설정할수있음
	}
	//Method
	@Override
	public void run() {
		//String threadName = Thread.currentThread().getName(); //currentTread()는 주로 겟네임쓸라고 쓰는 경우가 많음/
		String threadName = getName();//스레드 안에서는 이렇게 겟네임을 바로 할수 있다.  스레드를 상속받았으니까.
		for(int i=0; i<2; i++){
			System.out.println(threadName+"가 출력한 내용");
		}
	}
	
}
