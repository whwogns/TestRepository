package study;

public class MultiCatchExample {

	public static void main(String[] args) {
		try{
			
		String data1 = null;
		String data2 = null;
		
			//예외 1
			data1 = args[0];
			data2 = args[1];
			
			//예외 2
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
			
		}catch(ArrayIndexOutOfBoundsException e){     //예외1에 대한 catch
		
			System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
			
			
		}catch(Exception e){     //나머지 예외에 대한 catch
			System.out.println("알수없는 예외 발생.");
		}finally{
			System.out.println("다시실행하세요");
		}
	}

}
