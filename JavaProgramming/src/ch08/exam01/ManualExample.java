package ch08.exam01;

public class ManualExample {

	public static void main(String[] args) {
		//Bike bike = new Bike();.
		Manual manual = new Bike(); //인터페이스에 객체를 입력해주므로써 인터페이스로써 실행할수 있다. (메뉴얼을 실행하면 바이크가 실행되므로)
		//Bike 대신 Car 를 써넣으므로써 메뉴얼로 카를 실행할수있다.,
		manual.turnOn();
		manual.setSpeed(10);
		manual.run();
		manual.turnOff();
		
		move(new Bike());
		move(new Car());
	}
	
	public static void move(Manual manual){
		manual.turnOn();
		manual.setSpeed(10);
		manual.run();
		manual.turnOff();
	} //일일이 각 객체를 불러올필요없이 매뉴얼을 넣어주므로써 무브를 실행할수있음.

}
