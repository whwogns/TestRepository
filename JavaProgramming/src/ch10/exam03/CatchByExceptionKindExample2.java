package ch10.exam03;

public class CatchByExceptionKindExample2 {

	public static void main(String[] args) {
		
		try{
		String str = null;
		System.out.println(str.length());
		
		
		int[] scores = {90,85};
		for(int i=0; i<3;i++){ 
			System.out.println(scores[i]);
		}
		
		
		String strNum ="a";
		int num = Integer.parseInt(strNum);
		}catch(NullPointerException e){
			
		}catch(ArrayIndexOutOfBoundsException e){
			
		}catch(NumberFormatException e){
			
		}
	}

}
//각 예외마다 트라이를 잡아도 상관없음. 
//한번에 트라이를 잡아도됨. 다중캐치
