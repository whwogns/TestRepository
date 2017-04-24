package ch10.exam02;

import java.util.Scanner;

public class RuntimeException {

	public static void main(String[] args) {
		
		try{
		String str = null;
		System.out.println(str.length()); 
		}catch(NullPointerException e){ // jvm이 예외 객체생성하고 이 주소를 변수e에 저장
			System.out.println(e.getMessage());	// 예외의 원인을 문자로 알려주는 메소드		
		}finally{
			System.out.println("정상적으로 실행되도록 함");
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("입력");
			String strNum = scanner.nextLine();
			try{
			int num =Integer.parseInt(strNum);
			}catch(NumberFormatException e){
					System.out.println("숫자만 입렵하시오");
			}
		}
		
	}

}
