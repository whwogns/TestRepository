package ch07.exam09;

public class CarExample {

	public static void main(String[] args) {
		
		//Tire tire=new NormalTire();//
	
		Car car1= new Car(new SnowTire());// 1. 생성자에 매개변수(타이어종류) 입력 함. 
		car1.run();               //해당 타이어기능이 실행됨/ run()을 실행하면 Car의 메소드가 실행되어  roll()이 실행됨.ㅣ
		
		Car car2= new Car(new NormalTire());// 1. 생성자에 매개변수(타이어종류) 입력 함. 
		car2.run();               //해당 타이어기능이 실행됨/ run()을 실행하면 Car의 메소드가 실행되어  roll()이 실행됨.ㅣ
		
		
	}

}
