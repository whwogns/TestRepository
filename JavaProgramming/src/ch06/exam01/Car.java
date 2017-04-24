package ch06.exam01;

public class Car {
	//Field
	String company="현대자동차";//값을 고정해도 되고 안해도되고 
	int speed; //속도라는 특성상 가변이므로 값을 고정적으로 넣어줘선 곤란함.
	String color;//나중에 객체생성후 색체 넣어줘도 되므로 고정x
	boolean airback;
	//Constructor
	Car(){
		System.out.println("Car 객체생성");//코드 내용 : 객체를 만드는 코드 /어떻게 만들지/이때 반드시 생성자가 만들어져야 객체생성이 가능하다 생성자가 없으면 알아서 컴파일러가 생성자를 만들어줌.
	}
	
	//Method
	void run(){
		System.out.println("현재"+speed+"km/h로 달립니다.");
	}

}
