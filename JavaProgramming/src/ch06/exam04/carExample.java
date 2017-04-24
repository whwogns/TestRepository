package ch06.exam04;

public class carExample {

	public static void main(String[] args) {
		
		//Car 객체 생성
		Robot myRobot = new Robot("2017-03-28","검정");
		//----------------------------------------------------
		// Engine의 메소드 호출
		myRobot.engine.start();
		myRobot.engine.stop();
		//Dashboard의 메소드 호출
		myRobot.dashboard.display(60);
		//Tire의 필드값 읽기
		System.out.println(myRobot.tires[0].location);
		//Tire의 메소드 호출
		myRobot.tires[2].roll();
		//-----------------------------------------------------
		//Car의 메소드 호출
		myRobot.start();
		myRobot.run();
		
		//---------------------------------------------------------------------------------------
		//Tire(앞좌) 부품교체
		myRobot.Leg[1] = new Tire("새앞좌");
		myRobot.run();
	}

}
