package ch08.exam01;

public class Bike implements Manual{  //�޴��� �������̽��� ���� ���� ������ ���ִ� Ŭ������¶�.
	//Field
	private int speed;
	//Constructor
	//Method   // �������̽��� ����Ʈ�� �ۺ�������  ���⼱ �Ⱦ��� ����Ʈ�Ƿ� public�� ������Ѵ�.
	  public void turnOn(){
		  System.out.println("���������Ÿ� �մϴ�.");
	  }
	  public void turnOff(){
		  System.out.println("���������Ÿ� ���ϴ�.");
	  }
	  public void setSpeed(int speed){
		  System.out.println("�ӵ���"+speed+"�� �����մϴ�.");
		  this.speed=speed;
				  
	  }
	  public int getSpeed(){
		  return speed;
	  }
	  public void run(){
		  System.out.println("���������Ű�"+speed+"�ӵ��� �޸��ϴ�.");
	  }
}
