package ch06.exam01;

public class CarExample {

	public static void main(String[] args) {
		
		//��ü ���� �ڵ�
		Car myCar = new Car();//
		
		//��ü�� �޼ҵ� ȣ��
		//myCar.run();
		
		//��ü�� �ʵ� �б�
		System.out.println(myCar.company);
		System.out.println(myCar.speed);
		//��ü�� �����Ǹ鼭 �ʵ�� �ڵ����� �ʱ�ȭ�� ���ÿ� �ȴ�. �׷��� ������ ���̰� �ִ�. ������ ���������ϸ� ����������
		System.out.println(myCar.color);
		System.out.println(myCar.airback);
		
		//��ü�� �ʵ尪�� ����
		myCar.speed=30;
		myCar.color="���";
		myCar.run();
	
	
		
		//--------------------------------
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.speed);
		System.out.println(yourCar.color);
		System.out.println(yourCar.airback);
	}

}
