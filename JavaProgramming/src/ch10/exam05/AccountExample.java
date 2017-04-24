package ch10.exam05;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("잔고: +"+account.getBalance());
		account.deposit(100000);
		System.out.println("잔고: +"+account.getBalance());
		try {
			account.withdraw(1000000);
		} catch (BalaceInsufficientException e) {
			//예외처리코드
			System.out.println(e.getMessage());
		}
		System.out.println("잔고: +"+account.getBalance());
	}

}

//어플리케이션 예외 : 자바가 제공안하는 예외로써, 해당하는 예외를 만들어서 써야하는 경우
//예를 들어 잔고부족 같은 예외를 발생시키고싶은 경우.
