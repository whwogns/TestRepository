package ch06.exam07;

public class calculator {
	 	//Field
		static String model = "MI-84";
		static String makeDay="2017.03.29";
		static String info; //MI-84(2017.03.29)
		//static block : 필드에서 연산을 할 필요가 있을때, 생성자에서는 객체만드는 것이고 객체아닌 것을 만드는때에는 스태틱을 사용한다. 이때 스태틱은 메소드가 다 끝나면 실행됨.
		//스태틱필드의 복잡한 계산을 해줌.
		
		static{
			info = model;
			info +="(";
			info += makeDay;
			info +=")";
		//이 스태틱블록안에는 객체가 생성된 것을 넣어선 안된다.
	}
	
	//
}
