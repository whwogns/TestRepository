package ch08.exam01;

public class ManualExample {

	public static void main(String[] args) {
		//Bike bike = new Bike();.
		Manual manual = new Bike(); //�������̽��� ��ü�� �Է����ֹǷν� �������̽��ν� �����Ҽ� �ִ�. (�޴����� �����ϸ� ����ũ�� ����ǹǷ�)
		//Bike ��� Car �� ������Ƿν� �޴���� ī�� �����Ҽ��ִ�.,
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
	} //������ �� ��ü�� �ҷ����ʿ���� �Ŵ����� �־��ֹǷν� ���긦 �����Ҽ�����.

}
