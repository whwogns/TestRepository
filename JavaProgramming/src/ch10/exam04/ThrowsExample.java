package ch10.exam04;

import java.io.IOException;

public class ThrowsExample {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		try {
			Class.forName("");
			System.in.read();
		}catch (Exception e){
			//����ó���ڵ�
		}
		
		try{
		divide(10,0);    //���⼭ ȣ���ϴ� �̶� ����ó���Ѵ�.
		}catch(ArithmeticException e){
			System.out.println("0���� ������ �ȵ˴ϴ�.");
		}
	}

	static void divide(int x, int y) throws ArithmeticException{ //�����⸸ ���ٻ��̰� ���ܴ� ȣ���ϴ��ʿ��� ó����.
		
		int result = x/y;
	
		
	}
}
