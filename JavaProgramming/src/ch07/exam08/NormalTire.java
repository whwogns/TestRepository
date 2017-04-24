package ch07.exam08;

public class NormalTire extends Tire {
//Field
//Constructor
	NormalTire(){
		super();
		System.out.println("NormalTire 객체 생성");
	}
//Method
	@Override
	void roll() {
		System.out.println("일반타이어가 굴러간다.");
	}
}
//exam07과 차이는 자식클래스에서 반드시 재정의를 해주어야한다.