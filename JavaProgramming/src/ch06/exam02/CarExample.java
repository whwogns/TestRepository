package ch06.exam02;

public class CarExample {

	public static void main(String[] args) {
		
	
		Car myCar = new Car();//
		
		
		System.out.println(myCar.company);
		System.out.println(myCar.speed);
		System.out.println(myCar.color);
		System.out.println(myCar.airback);
		
		Car yourCar = new Car("검정",true);
		System.out.println(yourCar.company);
		System.out.println(yourCar.speed);
		System.out.println(yourCar.color);
		System.out.println(yourCar.airback);
		
		yourCar = new Car("검정",false);
		System.out.println(yourCar.company);
		System.out.println(yourCar.speed);
		System.out.println(yourCar.color);
		System.out.println(yourCar.airback);
		//이렇게 하면 yourCar 객체 주소가 새로 설정되므로 바로전의 생성된 객체는 쓰레기 객체가됨.
		
	}

}
