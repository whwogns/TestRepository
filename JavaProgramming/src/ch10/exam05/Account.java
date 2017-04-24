package ch10.exam05;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	
	public void deposit(int money){
		balance += money;
	}
	
	public void withdraw(int money) throws BalaceInsufficientException{    /// ���ܸ� ���Ƿ� �����ϰ��� �ϴ°�. ��������ǿ���
		if(balance<money){
			//throw new BalaceInsufficientException(); //���ܹ߻��ڵ�.������ Ʈ��� ���ܸ� �߻���Ų��. throw�� throws�� �����ϵ���.
			throw new BalaceInsufficientException("�ܰ����"); //���� ������ �̷��� �޼����� ���൵ ��.
		}
		
		balance -= money;
	}

	
}
