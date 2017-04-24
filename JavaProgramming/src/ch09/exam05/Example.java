package ch09.exam05;

public class Example {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();   // A객제를 먼저 만들고 A를 통해 B로 접근// 이런 경우 근데 드뭄.       /// 클래스가 인스턴스일때
		
		Main.C = new A.C(); //스태틱이 있기때문에 이렇게 쓸 수 있다. //이렇게 쓰이는 경우가 훨씬많다.      /// 클래스가 스태틱일때

	}
}
