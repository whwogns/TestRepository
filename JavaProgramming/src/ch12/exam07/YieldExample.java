package ch12.exam07;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threadA.setWork(false);
				
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threadA.setWork(true);
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		//thread.stop();  //가급적 쓰지말고
		threadA.setStop(true); // 부모타입Thread로 하면 자식객체를 쓸수 없으니 ThreadA 타입으로 해야함.
		threadB.setStop(true);
	}

}
