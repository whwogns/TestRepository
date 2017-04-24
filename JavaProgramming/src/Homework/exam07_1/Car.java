package Homework.exam07_1;

public class Car {
	Tire tire;
	
	Car(Tire tire){     //타이어객체에 따라서(타이어라는 매개변수를 이용한것임.) 자동차의 객체가 달라지도록 한것.
		this.tire=tire; //왜 이렇게 코드를 쓰냐면, 필드의 초기화를 위한것인데 필드 초기화를 하기위해선 필드에서 직접 초기값을 넣어줄수도있지만 그럼 고정값이되버림. 
		//그래서 객체 생성시마다 그에 맞게 초기화가 되게 하기 위해서는 이렇게 생성자코드에서 초기화를 해준다.
	}
	
	void run(){
		tire.roll();
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}

	

}
