package ch11.exam13;

public class WrapperEqualsExample {

	public static void main(String[] args) {
		Integer v1 = 1000;  // =new Integer(10)
		Integer v2 = 1000; // =new Integer(10)
		
		System.out.println(v1 == v2); //객체 비교
		System.out.println(v1.intValue()==v2.intValue()); // 객체안에 값을 빼내어 비교
		System.out.println(v1.equals(v2)); // 재정의된 이퀄스므로 값을 비교하는것임.
	}

}
//* 기본타입이 아닌이상 '=='로 값비교 하지마라! 엉뚱한 결과가 나올 경우가 있다. 가능하면 '=='쓰지 않도록하고 .equals()를 이용한다.