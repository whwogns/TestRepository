package ch09.exam04;

public class A {
	//Field
	int field;
	//Constructor
	//Method
	//Nested Class (중첩 멤버 클래스)
	class B {
		//Field
		int field;
		//Constructor
		//Method
		void method(){
			field=10;     // 이때의 필드는 가장가까운 B의 필드이다.(=> this.field=10;)
			A.this.field=10; // B의 필드 말고 A의 필드를 갖다쓸때 쓰이는 방법임.
		}
		
	} 
}



