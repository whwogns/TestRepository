package Homework.exam07_1;

public class CarExample {

	public static void main(String[] args) {
		
		Car car = new Car(new Tire()); //Ÿ�̾� �����ڴ� �⺻�����ڹǷ� new Tire()�̰� �̸� �Ű������� �־��ָ� new Car()�ν� ���ο� ��ü�� ������.
		car.run();
		
		car.setTire(new SnowTire());
		car.run();
		
		car.setTire(new NormalTire());
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
	}

}
