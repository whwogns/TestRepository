package ch06.exam04;

public class Car {

	
	//Field
		Body Body= new Body();//카객체를 만들면 바디객체도 함께 만들어지고, 포함관계가아니고 참조하는것.
		Engine engine = new Engine();
		Dashboard dashboard = new Dashboard();
		//Seat[] seat = new seat[4];//시트객체 4개가 생성된게 아니라 배열만 생성된것일뿐.
		Seat[] seats = { new Seat(), new Seat(), new Seat(), new Seat()};
		Tire[] tires = {new Tire("앞우"),new Tire("앞좌"),new Tire("뒤우"),new Tire("뒤좌")};
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
			setSpeed(60); // 같은 클래스안에 있는 객체므로 별도의 변수 없어도 됨.
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
