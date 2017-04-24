package ch11.exam15;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// Math.Random();
		
		
		int maxNum=6;
		 /* HOW1
		double random = Math.random();
		
		int num = (int)random*maxNum+1;
		System.out.println(num);
		
		*/
		
		//HOW2
		
		Random obj = new Random();
		int num2 = obj.nextInt(maxNum)+1;  //nextInt(bound)로 범위내에서 int 랜덤값 생성
		System.out.println(num2);
		}

	}


