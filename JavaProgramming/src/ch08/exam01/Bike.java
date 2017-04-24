package ch08.exam01;

public class Bike implements Manual{  //메뉴얼 인터페이스의 설명에 따라 실행할 수있는 클래스라는뜻.
	//Field
	private int speed;
	//Constructor
	//Method   // 인터페이스는 디폴트로 퍼블릭있으나  여기선 안쓰면 디폴트므로 public을 써줘야한다.
	  public void turnOn(){
		  System.out.println("전동자전거를 켭니다.");
	  }
	  public void turnOff(){
		  System.out.println("전동자전거를 끕니다.");
	  }
	  public void setSpeed(int speed){
		  System.out.println("속도를"+speed+"로 변경합니다.");
		  this.speed=speed;
				  
	  }
	  public int getSpeed(){
		  return speed;
	  }
	  public void run(){
		  System.out.println("전동자전거가"+speed+"속도로 달립니다.");
	  }
}
