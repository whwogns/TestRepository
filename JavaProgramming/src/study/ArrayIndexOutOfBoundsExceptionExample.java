package study;

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String args[]){
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0]:"+data1);
		System.out.println("args[1]:"+data2);
		
	}

}
//메인 메소드에 대한 실행이 되지 않았으니 실행 매개값이 없으므로 있지도 않은 배열을 출력시키므로 해당 예외가 발생한다.
