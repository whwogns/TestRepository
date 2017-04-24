package ch06.exam01;

public class CarExample {

	public static void main(String[] args) {
		
		//객체 생성 코드
		Car myCar = new Car();//
		
		//객체의 메소드 호출
		//myCar.run();
		
		//객체의 필드 읽기
		System.out.println(myCar.company);
		System.out.println(myCar.speed);
		//객체가 생성되면서 필드는 자동으로 초기화도 동시에 된다. 그래서 변수와 차이가 있다. 변수는 값지정안하면 읽히지않음
		System.out.println(myCar.color);
		System.out.println(myCar.airback);
		
		//객체의 필드값을 변경
		myCar.speed=30;
		myCar.color="흰색";
		myCar.run();
	
	
		
		//--------------------------------
		Car yourCar = new Car();
		System.out.println(yourCar.company);
		System.out.println(yourCar.speed);
		System.out.println(yourCar.color);
		System.out.println(yourCar.airback);
	}

}
