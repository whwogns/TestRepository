package ch06.exam03;


public class Calculator {
	
	//Field
	
	// costructor
	
	//Method
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	void powerOff(){
		System.out.println("전원을 끕니다.");
	}
	
	String info() {
		return "삼성전자-2017-03.28";
	}
	
	int plus(int x, int y) {
		int result = x+y;
		return result;
	}


double plus(double x, double y) {  //메소드 오버로딩은 타입만 달라선 안되고 매개변수가 달라야함.
	double result = x+y;
	return result;
}
	
	double divide(double x, double y){
		double result=x/y;
		return result;
	}
	int[] changeArray(int x, int y, int z){
		int[] array={x,y,z};
		return array;
	}
	
	Car makeCar(String color, boolean airback){//어디에있는 car 설계도를 가지고 할지 결정해줘야한다.//컨트롤 시프트 o를 하면  지정됨.
		Car car = new Car(color, airback);
		return car;
		
	}
}
