package ch06.exam11.pack1;

 public class A {//public 의 의미는 '누구든지'로써 같은패키지건 다른패키지건 구분없이 사용가능하다 퍼블릭있는상태에서 다른 패키지면 임포트가 붙는다. 퍼블릭이 없으면 이런것안됨
	 //퍼블릭 없으면 같은패키지에서만 사용가능
	 
	 public int field1;
//생성자 선언안해도 임시적으로 알아서 생성된다. 이때 생성자의 형태는 클래스가 퍼블릭있으면 생성자도 퍼블릭있고 없어면 없다.
	 public A() {} // 생성자도 마찬가지로 퍼블릭있으면 어떤 패키지에 있건 사용가능. 
	 
	 public void method(){
		 
	 }
}
