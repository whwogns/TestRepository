package ch07.exam08;

public class TireExample {

	public static void main(String[] args) {
		//Tire tire= new Tire(); //부모객체를 만들 수없다. 추상클래스는 뉴로 부모객체를 생성못함.
		Tire tire1 = new NormalTire();
		tire1.roll();
		
		Tire tire2= new SuperTire();
		tire2.roll();
	}

}
