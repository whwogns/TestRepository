package ch07.exam08;

public class TireExample {

	public static void main(String[] args) {
		//Tire tire= new Tire(); //�θ�ü�� ���� ������. �߻�Ŭ������ ���� �θ�ü�� ��������.
		Tire tire1 = new NormalTire();
		tire1.roll();
		
		Tire tire2= new SuperTire();
		tire2.roll();
	}

}
