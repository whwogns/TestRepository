package ch11.exam13;

import java.util.Arrays;

public class EqualsExample {

	public static void main(String[] args) {
		int[][] original = {{1,2},{3,4}};
		
		
		System.out.println("[얕은 복제후 비교]");
		int[][] cloned1 = Arrays.copyOf(original, original.length);// (오리지날을 복사하는데 , 오리지날 길이대로 복제)  (복사할 배열 대상, 복제해서 생성할 배열의 길이)
		System.out.println("배열 번지 비교:"+original.equals(cloned1));// 오리지날과 클론1의 객체가 다르다는 의미. 즉 복제하여 새로운 객체가 생성된것.
		System.out.println("1차 배열 항목값 비교 :"+Arrays.equals(original, cloned1));//오리지날과 클론1의 얕은 비교를 하여, 번지수가 같으므로 true
		System.out.println("중첩 배열 항목값 비교 :"+Arrays.deepEquals(original, cloned1)); // 오리지날과 클론1의 깊은 비교를 하여 같은 값을 갖으므로 true
		
		
		System.out.println("\n[깊은복사후 비교]");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		System.out.println("배열 번지 비교 ;"+original.equals(cloned2));
		System.out.println("1차 배열 항목값 비교:"+Arrays.equals(original, cloned2));
		System.out.println("중첩 배열 항목값 비교 :"+Arrays.deepEquals(original, cloned2));

	}

}
