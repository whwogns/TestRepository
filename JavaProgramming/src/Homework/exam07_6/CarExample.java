package Homework.exam07_6;

public class CarExample {

	public static void main(String[] args) {
		
		Car car =new Car(new Tire());
		car.run();
		
		car.setTire(new SnowTire());
		car.run();
		
		car.setTire(new NormalTire());
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
	}

}
