package ch14.exam03;

public class LambdaExpressionExample {
	public static int a=5;

	public static void main(String[] args) {
		method1(()-> {
			a=8;
			System.out.println(a);
		});
		
		int b = 5;
		method1(()-> {
			//b=8;   //익명개체 final이므로 값을 바꿀수없다.
			System.out.println(b);
		});
		
		
	}
	public static void method1(FunctionalInterface1 i) {
		i.method();
	
		}
	}

