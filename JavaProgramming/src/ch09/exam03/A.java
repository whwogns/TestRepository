package ch09.exam03;

public class A {
	//Field
	//Constructor
	
	A(){ 
		int localVariable =2; //로컬변수는 파이널을 붙여야 함. 1.8버전 전에서는 final을 붙여야 하나 1.8버전에서는 가능함. // 즉 자바 1.8에서는 로컬변수내에서는 디폴트로 final이 붙어있음.
		//로컬 클래스
		class D {
			//Field
			//Constructor
			//Method
			void dMethod(){
				int result = localVariable + 8;
				//localVariable =10; //final이 붙었으니 값변경불가 --- 
			}
		}
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

