package ch08.exam01;

public interface Manual { 
	
	//Field 
	 String COMPANY="삼성전자"; //상수를 선언한다. public static final은 기본적으로 생략되어 있으므로 디폴트로 들어가있으니 굳이 쓸필요없다.
	 int MAX_SPEED=150;
	 int MIN_SPEED=0;
	 //인터페이스로 사용가능한 객체로써 실제 객체안에도 아래 메소드도 당연히 갖고있어야한다. 인터페이스에 나온 객체를 인터페이스로 구현된 객체라 한다.
	//Method
	  void turnOn();//public abstract 이것이 기본적 디폴트값이므로 붙이지 않는것이 관례이다. 실행부를 {}나타낼필요없다.
	  void turnOff();
	  void setSpeed(int speed);
	  int getSpeed();
	  void run();
}
