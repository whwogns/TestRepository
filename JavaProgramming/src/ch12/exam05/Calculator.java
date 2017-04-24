package ch12.exam05;

public class Calculator {//공유객체 설정
	
	//Field
	private int memory;
	//Constructor
	//Method

	public int getMemory() {
		return memory;
	}

	public synchronized void  setMemory(int memory){ ///싱크로나이즈드를 붙이지 않으면 유저1 유저2 모두 이메소드를 실행할수있게 되고, 붙어면 유저1만 실행되게끔 할 수있다.
		//공유객체 안에 있는 메소드에 싱크로나이즈드가 붙게된다.

		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName() + ":"+this.memory);
	}
}
