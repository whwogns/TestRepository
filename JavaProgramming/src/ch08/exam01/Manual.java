package ch08.exam01;

public interface Manual { 
	
	//Field 
	 String COMPANY="�Ｚ����"; //����� �����Ѵ�. public static final�� �⺻������ �����Ǿ� �����Ƿ� ����Ʈ�� �������� ���� ���ʿ����.
	 int MAX_SPEED=150;
	 int MIN_SPEED=0;
	 //�������̽��� ��밡���� ��ü�ν� ���� ��ü�ȿ��� �Ʒ� �޼ҵ嵵 �翬�� �����־���Ѵ�. �������̽��� ���� ��ü�� �������̽��� ������ ��ü�� �Ѵ�.
	//Method
	  void turnOn();//public abstract �̰��� �⺻�� ����Ʈ���̹Ƿ� ������ �ʴ°��� �����̴�. ����θ� {}��Ÿ���ʿ����.
	  void turnOff();
	  void setSpeed(int speed);
	  int getSpeed();
	  void run();
}
