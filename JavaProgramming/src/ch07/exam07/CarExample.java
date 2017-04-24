package ch07.exam07;

public class CarExample {

	public static void main(String[] args) {
		
		//Tire tire=new NormalTire();//
	
		Car car= new Car(new SnowTire());// 1. 생성자에 매개변수(타이어종류) 입력 함. 
		car.run();               //해당 타이어기능이 실행됨/ run()을 실행하면 Car의 메소드가 실행되어  roll()이 실행됨.ㅣ
		
		
		car.setTire(new NormalTire());//2. 세터에 의해 객체를 노말타이어로 바꿔줌 
		car.run();
		
		car.setTire(new SpeedTire());//3. 세터에 의해 객체를 스피드타이어로 바꿔줌
		car.run();
		
		car.setTire(new SuperTire());//4. 세터에 의해 객체를 슈퍼타이어로 바꿔줌
		car.run();
		
	}

}
