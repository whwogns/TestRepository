package Homework.exam07_0;

public class Car {
	
	public Tire tire;
	
	public Car(Tire tire){
		this.tire=tire;
	}
	void run(){
		tire.roll();
	}
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	

}
