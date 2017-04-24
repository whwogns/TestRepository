package study;

public class NumberFormatExceptionExample {

	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);//data1은 숫자로만 되어 있으니 숫자로 변환 가능하므로 예외발생하지 않는다. //NumberFormatException
		//cf/ Integer.parseInt() -> 문자열을 숫자로 변환시키는 메소드
		int result = value1 + value2;
		System.out.println(data1+"+"+data2+"="+result);
	
	}

}
