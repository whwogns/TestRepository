package ch12.exam03;

public class WorkThread extends Thread {
	//Field
	//Constructor
	WorkThread(String threadName){
		//super(threadName);
		setName(threadName); //�̷��Ե� ������ �̸��� �����Ҽ�����
	}
	//Method
	@Override
	public void run() {
		//String threadName = Thread.currentThread().getName(); //currentTread()�� �ַ� �ٳ��Ӿ���� ���� ��찡 ����/
		String threadName = getName();//������ �ȿ����� �̷��� �ٳ����� �ٷ� �Ҽ� �ִ�.  �����带 ��ӹ޾����ϱ�.
		for(int i=0; i<2; i++){
			System.out.println(threadName+"�� ����� ����");
		}
	}
	
}