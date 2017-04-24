package ch09.exam05;

public class A {
	//Field
	//Constructor
	
	A(){
		//로컬 클래스
		class D {}
		D d = new D(); // 외부에서 호출전에 여기서 객체 생성을 해야함. 왜냐면 블록이 끝나면 D클래스는 사라지므로~
	}
	//Method
	void method(){
		//로컬클래스
		class E{}
	}
	
	//Nested Class (중첩 멤버 클래스)
	class B {} 
	static class C{} 
}
