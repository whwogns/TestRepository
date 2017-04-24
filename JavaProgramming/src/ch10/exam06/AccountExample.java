package ch10.exam06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("잔고: +"+account.getBalance());
		account.deposit(100000);
		System.out.println("잔고: +"+account.getBalance());
		try {
			account.withdraw(1000000);
		} catch (BalaceInsufficientException e) {
			e.printStackTrace(); //어디서 예외가 발생되었는지 추적해보겠다는것. 개발과정에서 유용하게 쓰이고 개발 완료후에는 지우라. 
			System.out.println("-----------------");
			System.out.println(e.toString()); //크게 많이 쓰이지는 않는다.
			System.out.println("-----------------");
			System.out.println(e.getMessage());
			
			//예외 발생 내역을 출력하는 방법 3가지. 얼마나 자세히 출력시켜주는지 나타내는것.
		}
		System.out.println("잔고: +"+account.getBalance());
	}

}

