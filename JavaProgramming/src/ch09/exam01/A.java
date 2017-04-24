package ch09.exam01;

public class A {
	//Field
	//Constructor
	
	A(){
		//로컬 클래스
		class D {}
	}
	//Method
	void method(){
		//로컬클래스
		class E{}
	}
	
	//Nested Class (중첩 멤버 클래스)
	class B {} // 스태틱이 안붙었으니 A객체없이는 A에는 접근못함.  // A를 떠나서는 B가 의미없는 경우에 쓰임
	static class C{} //A클래스(A객체) 없이도 C사용가능  얘를 더 많이씀.  // A와 전혀 관계없으나 A에서 유래한것이라는 것을 알리기 위해 쓰임.
}
//생성자 안에 메소드안에 어디든 클래스 또 넣을수있다.//근데 이렇게는 잘 만들진 않음.

