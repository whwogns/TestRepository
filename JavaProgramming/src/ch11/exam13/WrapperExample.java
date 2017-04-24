package ch11.exam13;

public class WrapperExample {

	public static void main(String[] args) {
		
		int v1 = 10;
		
		Integer v2 = 10; //10이저장이 되는게 아니라 인티져객체를 생성하여 거기에 10을 대입한것이고 v2에는 그 객체의 번지가 입력됨.  //오토박싱
		int v3 = v2; //v2객체안에 데이터값인 10을 빼내서 인트값으로 v3에 넣어준다.   //오토언박싱
		
		method1(3); //3을 가지고 있는 객체를 생성하여 메소드에 저장된다.//오토박싱
		int v4 = method2();//오토 언박싱
	}
	
	 public static void method1(Integer obj){};
	 public static Integer method2(){return 1;}//인티져가 자동으로 인트값으로 바꾸어서 v4에 저장됨.
}

