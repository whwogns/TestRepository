package Homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
		List<String> list1=Arrays.asList("홍길동","신용권","감자바");
		for(String name : list1){
			System.out.println(name);
		}
		
		List<Integer> list2 = new ArrayList<>();
		
	}

}
