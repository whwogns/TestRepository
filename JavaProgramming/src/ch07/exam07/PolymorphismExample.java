package ch07.exam07;

public class PolymorphismExample {

	public static void main(String[] args) {
		Tire tire1 = new Tire();
		
		NormalTire tire2 = new NormalTire();
		
		SnowTire tire3 = new SnowTire();
		
		run(tire1);
		run(tire2);//=Tire tire = tire2;
		run(tire3);// = Tire tire = tire3;
	}
	
	 static void run(Tire tire){  //tire1을 넣으면 tire의 기능, tire2를 넣으면 NormalTire, tire3을 넣으면 SnowTire 기능호출됨.(부품교체와 밀접함) 다형성.
		 tire.roll();
		
	}
}
