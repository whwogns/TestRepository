package ch07.exam08;

public class Car {
	//Field
	private Tire tire;   //2. 생성자 매개변수의 타이어가 필드가 선언된다.
	//Constructor
	public Car(Tire tire){//Tire tire= new SnowTire();
		this.tire=tire;         // 1. 매개변수를 만들어서 그곳에 어떤 타이어를 넣느냐에 따라 그 타이어의 객체를 생성시킴. / 즉 외부에서 타이어를 받고
	}
	//Method
	
	public void run(){     //3. 생성자의 매개변수의 타이어의 기능을 나타낸다.
		tire.roll();
	}

	public void setTire(Tire tire) {      //4. 메소드를 통해서 객체를 변환하기 위해 세터를 이용.
		this.tire = tire;
	}

}
