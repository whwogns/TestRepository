package ch06.exam04;

public class carExample {

	public static void main(String[] args) {
		
		//Car ��ü ����
		Robot myRobot = new Robot("2017-03-28","����");
		//----------------------------------------------------
		// Engine�� �޼ҵ� ȣ��
		myRobot.engine.start();
		myRobot.engine.stop();
		//Dashboard�� �޼ҵ� ȣ��
		myRobot.dashboard.display(60);
		//Tire�� �ʵ尪 �б�
		System.out.println(myRobot.tires[0].location);
		//Tire�� �޼ҵ� ȣ��
		myRobot.tires[2].roll();
		//-----------------------------------------------------
		//Car�� �޼ҵ� ȣ��
		myRobot.start();
		myRobot.run();
		
		//---------------------------------------------------------------------------------------
		//Tire(����) ��ǰ��ü
		myRobot.Leg[1] = new Tire("������");
		myRobot.run();
	}

}
