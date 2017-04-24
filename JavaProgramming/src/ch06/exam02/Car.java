package ch06.exam02;

public class Car {
	//Field
	String company="현대자동차";//값을 고정해도 되고 안해도되고 
	int speed; //속도라는 특성상 가변이므로 값을 고정적으로 넣어줘선 곤란함.
	String color;//나중에 객체생성후 색체 넣어줘도 되므로 고정x
	boolean airback;
	//Constructor
	
	Car(){
		this("현대자동차",null, false); //this(내가 생성한 또다른 생성자)호출
	}
	Car(String color, boolean airback){
		this.color = color; //현재 객체를 참조 자신의 객체를 지칭. this를 붙여서 자기필드이름을 지칭.
		this.airback = airback;
		
	}
	Car(String company, String color, boolean airback){
		this.company = company;
		this.color = color;
		this.airback = airback;
	}
	
	//생성자를 여러개 만드는걸 오버로딩 객체를 만들수 있는 방법이 여러개라는 것임.  각각의 생성자는 매개변수의 타입이 다르던가 타입의 순서이 다르고 갯수도 달라야함.
	//Method
	void run(){
		System.out.println("현재"+speed+"km/h로 달립니다.");
	}

}
