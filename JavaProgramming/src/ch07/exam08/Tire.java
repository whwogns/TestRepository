package ch07.exam08;

public abstract class Tire {  //추상클래스라도 추상 메소드만 있어야하는것은아니다.
	
	//Field
	int diameter;
	//Constructor
	Tire(){
		System.out.println("Tire 객체 생성");
	}
	//Method
	abstract void roll();
	
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
}
//추상 메소드 선언.