package ch12.exam05;

public class Calculator {//������ü ����
	
	//Field
	private int memory;
	//Constructor
	//Method

	public int getMemory() {
		return memory;
	}

	public synchronized void  setMemory(int memory){ ///��ũ�γ�����带 ������ ������ ����1 ����2 ��� �̸޼ҵ带 �����Ҽ��ְ� �ǰ�, �پ�� ����1�� ����ǰԲ� �� ���ִ�.
		//������ü �ȿ� �ִ� �޼ҵ忡 ��ũ�γ�����尡 �ٰԵȴ�.

		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		System.out.println(Thread.currentThread().getName() + ":"+this.memory);
	}
}
