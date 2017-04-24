package ch06.exam11.pack1;

public class B {
	A a= new A();
	
	void method(){
		a.field1 = 10;//메소드에서도 퍼블릭있으면 다른패키지에서도 쓸수있다.
		a.method();
	}
}
