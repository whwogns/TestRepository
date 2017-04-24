package study;

public class ArrayIndexOutOfBoundsExceptionExample2 {
	public static void main(String args[]){
		
		if(args.length ==2){
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0]:"+data1);
		System.out.println("args[1]:"+data2);
		} else {
			System.out.println("[실행방법]");
			System.out.println("java ArrayIndexOutOfBoundsExceptionExample2");
			System.out.println("값1 값2");
		}
	}

}
//예외에 대해 사용자에게 실행시킬수 있는 방법을 제시해준다. (일종의 예외처리코드로 볼 수 있다.)