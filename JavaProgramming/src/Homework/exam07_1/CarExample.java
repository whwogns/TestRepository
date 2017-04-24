package Homework.exam07_1;

public class CarExample {

	public static void main(String[] args) {
		
		Car car = new Car(new Tire()); //타이어 생성자는 기본생성자므로 new Tire()이고 이를 매개값으로 넣어주면 new Car()로써 새로운 객체가 생성됨.
		car.run();
		
		car.setTire(new SnowTire());
		car.run();
		
		car.setTire(new NormalTire());
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
	}

}
