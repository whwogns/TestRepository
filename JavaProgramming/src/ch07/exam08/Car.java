package ch07.exam08;

public class Car {
	//Field
	private Tire tire;   //2. ������ �Ű������� Ÿ�̾ �ʵ尡 ����ȴ�.
	//Constructor
	public Car(Tire tire){//Tire tire= new SnowTire();
		this.tire=tire;         // 1. �Ű������� ���� �װ��� � Ÿ�̾ �ִ��Ŀ� ���� �� Ÿ�̾��� ��ü�� ������Ŵ. / �� �ܺο��� Ÿ�̾ �ް�
	}
	//Method
	
	public void run(){     //3. �������� �Ű������� Ÿ�̾��� ����� ��Ÿ����.
		tire.roll();
	}

	public void setTire(Tire tire) {      //4. �޼ҵ带 ���ؼ� ��ü�� ��ȯ�ϱ� ���� ���͸� �̿�.
		this.tire = tire;
	}

}
