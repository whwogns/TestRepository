package ch07.exam06.pack1;

//패키지가 다르므로 임포트 생겨서 호출가능.
public class B extends A {

	public void test(){
		field = 10;
		method();
	}
}
//protected 가 붙어있으면 다른패키지에 있을때, 상속해야 필드 메소드 사용가능
//생성자에 protected가 붙으면 다른패키지라면 상속해야만 필드 메소드 사용가능
