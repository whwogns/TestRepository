package ch10.exam06;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		System.out.println("�ܰ�: +"+account.getBalance());
		account.deposit(100000);
		System.out.println("�ܰ�: +"+account.getBalance());
		try {
			account.withdraw(1000000);
		} catch (BalaceInsufficientException e) {
			e.printStackTrace(); //��� ���ܰ� �߻��Ǿ����� �����غ��ڴٴ°�. ���߰������� �����ϰ� ���̰� ���� �Ϸ��Ŀ��� �����. 
			System.out.println("-----------------");
			System.out.println(e.toString()); //ũ�� ���� �������� �ʴ´�.
			System.out.println("-----------------");
			System.out.println(e.getMessage());
			
			//���� �߻� ������ ����ϴ� ��� 3����. �󸶳� �ڼ��� ��½����ִ��� ��Ÿ���°�.
		}
		System.out.println("�ܰ�: +"+account.getBalance());
	}

}

