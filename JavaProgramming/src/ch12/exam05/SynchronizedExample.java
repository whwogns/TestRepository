package ch12.exam05;

public class SynchronizedExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		
		User1 user1 = new User1(); //스레드 객체 생성
		user1.setCalculator(calc);
		user1.start();
		
		User2 user2 = new User2();// 스래드 객체 생성
		user2.setCalculator(calc);
		user2.start();
	}

}
