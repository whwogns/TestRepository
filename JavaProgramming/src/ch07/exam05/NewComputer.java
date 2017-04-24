package ch07.exam05;

public class NewComputer extends Computer{
		//c.f)보통 재정의는 메소드를 재정의함.
	
	@Override
	double circleArea(double r) {
		return Math.PI *r*r; //재정의한것임. / 이때  plus 메소드는 파이널이 붙어있으니 오버라이딩 할 수 없다.
	}

}
