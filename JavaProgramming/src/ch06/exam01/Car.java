package ch06.exam01;

public class Car {
	//Field
	String company="�����ڵ���";//���� �����ص� �ǰ� ���ص��ǰ� 
	int speed; //�ӵ���� Ư���� �����̹Ƿ� ���� ���������� �־��༱ �����.
	String color;//���߿� ��ü������ ��ü �־��൵ �ǹǷ� ����x
	boolean airback;
	//Constructor
	Car(){
		System.out.println("Car ��ü����");//�ڵ� ���� : ��ü�� ����� �ڵ� /��� ������/�̶� �ݵ�� �����ڰ� ��������� ��ü������ �����ϴ� �����ڰ� ������ �˾Ƽ� �����Ϸ��� �����ڸ� �������.
	}
	
	//Method
	void run(){
		System.out.println("����"+speed+"km/h�� �޸��ϴ�.");
	}

}
