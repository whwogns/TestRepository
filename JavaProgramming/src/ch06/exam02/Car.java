package ch06.exam02;

public class Car {
	//Field
	String company="�����ڵ���";//���� �����ص� �ǰ� ���ص��ǰ� 
	int speed; //�ӵ���� Ư���� �����̹Ƿ� ���� ���������� �־��༱ �����.
	String color;//���߿� ��ü������ ��ü �־��൵ �ǹǷ� ����x
	boolean airback;
	//Constructor
	
	Car(){
		this("�����ڵ���",null, false); //this(���� ������ �Ǵٸ� ������)ȣ��
	}
	Car(String color, boolean airback){
		this.color = color; //���� ��ü�� ���� �ڽ��� ��ü�� ��Ī. this�� �ٿ��� �ڱ��ʵ��̸��� ��Ī.
		this.airback = airback;
		
	}
	Car(String company, String color, boolean airback){
		this.company = company;
		this.color = color;
		this.airback = airback;
	}
	
	//�����ڸ� ������ ����°� �����ε� ��ü�� ����� �ִ� ����� ��������� ����.  ������ �����ڴ� �Ű������� Ÿ���� �ٸ����� Ÿ���� ������ �ٸ��� ������ �޶����.
	//Method
	void run(){
		System.out.println("����"+speed+"km/h�� �޸��ϴ�.");
	}

}
