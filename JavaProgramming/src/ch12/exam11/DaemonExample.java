package ch12.exam11;

public class DaemonExample {

	public static void main(String[] args) {
		
	System.out.println("�������μ����� ������");
	
	
	AutoSaveThread thread = new AutoSaveThread(); //�� ���佺���带 ����������� ������ָ� ��.
	thread.setDaemon(true);
	thread.start();
	
	try {thread.sleep(5000);} catch (InterruptedException e) {}
	System.out.println("�������μ����� ������");
	}
}