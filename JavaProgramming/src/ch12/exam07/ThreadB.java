package ch12.exam07;

public class ThreadB extends Thread {

	
	//Field
	private boolean stop = false;//�����带 �����ϱ� ���� ����
	private boolean work = true;//������ �۾��� �纸�ϱ� ���� ����
	//Constructor
	//Method
	@Override
	public void run() {
		while(!stop){
			if(work){   // work�� false�� ���ǹ��� �ݺ��� �һ� �̰��� ���ǹ��� ����ϻ��̹Ƿ� �̷��ٿ� �ٸ� �����带 �����Բ��ϴ°� ����.  �̸� �纸����.
			System.out.println("ThreadB �۾� ��....");
			}else{
				yield();//�ش� �����尡 ������ �ٸ� �����尡 ����ɼ��մ�.
				
			}
		}
		System.out.println("ThreadB�۾� ����");
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setWork(boolean work) {
		this.work = work;
	}
}
