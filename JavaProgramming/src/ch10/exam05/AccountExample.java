package ch10.exam05;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ�: +"+account.getBalance());
		account.deposit(100000);
		System.out.println("�ܰ�: +"+account.getBalance());
		try {
			account.withdraw(1000000);
		} catch (BalaceInsufficientException e) {
			//����ó���ڵ�
			System.out.println(e.getMessage());
		}
		System.out.println("�ܰ�: +"+account.getBalance());
	}

}

//���ø����̼� ���� : �ڹٰ� �������ϴ� ���ܷν�, �ش��ϴ� ���ܸ� ���� ����ϴ� ���
//���� ��� �ܰ���� ���� ���ܸ� �߻���Ű����� ���.
