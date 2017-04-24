package Homework.exam07_5;

public class Car {
	
	Tire tire;

	Car(Tire tire){
		this.tire=tire;
	}
	void run(){
		tire.roll();
	}
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
}
