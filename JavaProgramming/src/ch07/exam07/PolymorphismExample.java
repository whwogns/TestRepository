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
	
	 static void run(Tire tire){  //tire1�� ������ tire�� ���, tire2�� ������ NormalTire, tire3�� ������ SnowTire ���ȣ���.(��ǰ��ü�� ������) ������.
		 tire.roll();
		
	}
}
