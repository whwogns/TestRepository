package ch07.exam06.pack1;

import ch07.exam06.pack1.A;

public class C {
	
	public void test(){
		A a = new A();
		a.field = 10;
		a.method();
		
	}

}
//protected가 붙어있으면 다른패키지에 있을때, 이상태로는 필드 메소드 사용할 수 없음.