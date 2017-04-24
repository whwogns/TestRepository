package ch10.exam04;

import java.io.IOException;

public class ThrowsExample {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		try {
			Class.forName("");
			System.in.read();
		}catch (Exception e){
			//예외처리코드
		}
		
		try{
		divide(10,0);    //여기서 호출하니 이때 예외처리한다.
		}catch(ArithmeticException e){
			System.out.println("0으로 나누면 안됩니다.");
		}
	}

	static void divide(int x, int y) throws ArithmeticException{ //나누기만 해줄뿐이고 예외는 호출하는쪽에서 처리함.
		
		int result = x/y;
	
		
	}
}
