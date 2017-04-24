package study;

public class CatchOrderExample {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try{
			
			//예외 1
			data1 = args[0];
			data2 = args[1];
			
			//예외 2
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
			
		}catch(ArrayIndexOutOfBoundsException e){     //예외1에 대한 catch
		
			System.out.println("[실행방법]");
			System.out.println("java ArrayIndexOutOfBoundsExceptionExample2");
			System.out.println("값1 값2");
			
			
		}catch(Exception e){     //예외2에 대한 catch
			System.out.println("숫자로 변환할 수 없습니다.");
		}finally{
			System.out.println("다시실행하세요");
		}
	}

}

//위와 같을경우 예외2에 대해선 예외처리가 되지 않는 문제.  (순서상의 문제)
