package ch12.exam05;

public class SynchronizedExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		
		User1 user1 = new User1(); //������ ��ü ����
		user1.setCalculator(calc);
		user1.start();
		
		User2 user2 = new User2();// ������ ��ü ����
		user2.setCalculator(calc);
		user2.start();
	}

}
