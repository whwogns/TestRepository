package ch12.exam10;

public class PrintThread1 extends Thread {   //�÷��׸� �̿��ϴ� ���
	
	
	//Field
	private boolean stop;
	//Constructor
	//Method
	public void run(){
		while(!stop){  // �����帧�� �ٲٴ� ���� �÷��׶�� ��. ���⼱ stop������ �����׶���.
		System.out.println("������...");
		System.out.println("������...");
		}
		System.out.println("�ڿ�����");
		System.out.println("��������");
				
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
