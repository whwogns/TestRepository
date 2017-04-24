package study;

public class CatchByExceptionKindException {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try{
			data1 = args[0];
			data2 = args[1];
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
			System.out.println("실행매개값의 수가 부족합니다.");
			System.out.println("[실행방법]");
			System.out.println("java TryCatchFinallyRuntimeException");
			return;
		}catch(ArrayIndexOutOfBoundsException e){
		
		
			
		}catch(NumberFormatException e){
			System.out.println("숫자로 변환할 수 없습니다.");
		}finally{
			System.out.println("다시실행하세요");
		}
	}

}


//try로 한번에 다 묶고 다중catch로 한번에 예외처리하는 방법