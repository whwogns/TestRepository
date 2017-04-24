package ch14.exam05;

public class MethodReferenceExample {

	public static void main(String[] args) {
		method1(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				
				return a.equals(b);
			}
		});
		
		
		//위의 코드 줄이기 람다식
		
		method1((a,b)->{return a.equals(b);});
		method1((a,b)-> a.equals(b));
		method1(String :: equals);//이와 같은 코드의 메소드는 인스턴스가 와도 되고 스태틱이 와도 되는데, 
		//컴파일러는 다음과 같은 코드를 볼땐, 정적일때는 매개값으로 받는다/ 인스턴스라면 앞의 a.equals(매개값)으로 해석.
		
	}

	public static void method1(FunctionalInterface1 i){
		boolean result = i.method("Java", "java");
		System.out.println(result);
	}
}
