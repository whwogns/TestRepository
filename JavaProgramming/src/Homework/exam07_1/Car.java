package Homework.exam07_1;

public class Car {
	Tire tire;
	
	Car(Tire tire){     //Ÿ�̾ü�� ����(Ÿ�̾��� �Ű������� �̿��Ѱ���.) �ڵ����� ��ü�� �޶������� �Ѱ�.
		this.tire=tire; //�� �̷��� �ڵ带 ���ĸ�, �ʵ��� �ʱ�ȭ�� ���Ѱ��ε� �ʵ� �ʱ�ȭ�� �ϱ����ؼ� �ʵ忡�� ���� �ʱⰪ�� �־��ټ��������� �׷� �������̵ǹ���. 
		//�׷��� ��ü �����ø��� �׿� �°� �ʱ�ȭ�� �ǰ� �ϱ� ���ؼ��� �̷��� �������ڵ忡�� �ʱ�ȭ�� ���ش�.
	}
	
	void run(){
		tire.roll();
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	

}
