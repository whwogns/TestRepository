package ch12.exam07;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threadA.setWork(false);
				
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		threadA.setWork(true);
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		//thread.stop();  //������ ��������
		threadA.setStop(true); // �θ�Ÿ��Thread�� �ϸ� �ڽİ�ü�� ���� ������ ThreadA Ÿ������ �ؾ���.
		threadB.setStop(true);
	}

}