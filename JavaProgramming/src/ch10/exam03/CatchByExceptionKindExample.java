package ch10.exam03;

public class CatchByExceptionKindExample {

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
		}catch(NullPointerException |ArrayIndexOutOfBoundsException e){
			//코드1
		    System.out.println("예외처리코드1");
		}catch(NumberFormatException e){
			//코드2
			System.out.println("예외처리코드2");
		}
	}

}
//각 예외마다 트라이를 잡아도 상관없음. 
//한번에 트라이를 잡아도됨. 다중캐치 //// 이때 중복코드발생방지위해 파이프기호 |로 나열하여 이용
