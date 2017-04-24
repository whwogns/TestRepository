package ch06.exam04;

public class Car {

	
	//Field
		Body Body= new Body();//ī��ü�� ����� �ٵ�ü�� �Բ� ���������, ���԰��谡�ƴϰ� �����ϴ°�.
		Engine engine = new Engine();
		Dashboard dashboard = new Dashboard();
		//Seat[] seat = new seat[4];//��Ʈ��ü 4���� �����Ȱ� �ƴ϶� �迭�� �����Ȱ��ϻ�.
		Seat[] seats = { new Seat(), new Seat(), new Seat(), new Seat()};
		Tire[] tires = {new Tire("�տ�"),new Tire("����"),new Tire("�ڿ�"),new Tire("����")};
		String makeDay;
		String color;
		int speed;
		
	//Constructor
		Car(String makeDay, String color){
			this.makeDay = makeDay;
			this.color = color;
		}
		
	
	//Method
		void start(){
			engine.start();
		}
		void run(){
			
			tires[0].roll();
			tires[1].roll();
			tires[2].roll();
			tires[3].roll();
			setSpeed(60); // ���� Ŭ�����ȿ� �ִ� ��ü�Ƿ� ������ ���� ��� ��.
			dashboard.display(60);
			}
		
		void setSpeed(int speed){
			this.speed = speed;
		}
		void stop(){
			engine.stop();
			speed = 0;
		}
}
