package ch12.exam10;

public class PrintThread2 extends Thread {    //�÷��׸� �����ϴ� ���
	
	//Field
	private boolean stop;
	//Constructor
	//Method
	public void run(){
		try{
			while(true){  // �����帧�� �ٲٴ� ���� �÷��׶�� ��. ���⼱ stop������ �����׶���.
			System.out.println("������...");
			System.out.println("������...");
			//how1
			//Thread.sleep(1);   //�̰��� ���ͷ�Ʈ �Ͻ�������.
			//how2
			if(isInterrupted()){   //�̰��� ���ͷ�Ʈ �Ͻ���������    == ������ �ٱ������� thread.interrupted �����ִ�.
				
			
				break;
			}
		}
		
		}catch(Exception e){
			
		}
		System.out.println("�ڿ�����");
		System.out.println("��������");
	}
}
