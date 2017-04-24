package ch12.exam08;

public class JoinExample {

	public static void main(String[] args) {
		
		SumThread thread = new SumThread();
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {} // 메인스레드가 작업스레드가 끝날때까지 기다리겠다. 메인스레드가 join을실행하는것.
		
		long result = thread.getSum();
		System.out.println(result);
	}

}
