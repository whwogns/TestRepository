package ch11.exam13;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		
		System.out.println(Arrays.binarySearch(nums, 6));
		
		String[] names = {"홍길동","감자바","사물인터넷"};
		System.out.println(Arrays.binarySearch(names,"감자바2")); //음수값이 출력되면 값이 없다고 해석하면됨.
		}
	}
	

 
