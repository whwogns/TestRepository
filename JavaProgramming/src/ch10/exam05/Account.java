package ch10.exam05;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	
	public void deposit(int money){
		balance += money;
	}
	
	public void withdraw(int money) throws BalaceInsufficientException{    /// 예외를 임의로 설정하고자 하는것. 사용자정의예외
		if(balance<money){
			//throw new BalaceInsufficientException(); //예외발생코드.조건이 트루면 예외를 발생시킨다. throw와 throws를 구분하도록.
			throw new BalaceInsufficientException("잔고부족"); //예외 내용을 이렇게 메세지로 써줘도 됨.
		}
		
		balance -= money;
	}

	
}
