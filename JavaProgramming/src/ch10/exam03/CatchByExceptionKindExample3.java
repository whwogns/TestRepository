package ch10.exam03;

public class CatchByExceptionKindExample3 {

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
		
		}catch(NumberFormatException e){
			//코드1
			System.out.println("예외처리코드1");
		
		}catch(Exception e){    //모두 예외는 부모클래스 exception에 포함되는 자식클래스이다.
		//코드2
	    System.out.println("예외처리코드2");
		}
	}

}
// 캐치순서를 Exception을 마지막에 두면 먼저 넘버포멧익셉션부터 판단하고 나머지 모든 예외를 익셉션으로 판단한다,.