package ch11.exam13;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] names = {"홍길동","김민수","박동수"};
		System.out.println(Arrays.toString(names));
		
		// 올림차순으로 정렬
		Arrays.sort(names);   //sort()에는 comparable(compareTo()메소드)이 내포되어있어서 비교할 기준이 필요하다
		System.out.println(Arrays.toString(names));
		
		//내림차순으로 정렬
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names));
		
		
		Member[] members ={
			new Member("홍길동",20),
			new Member("김민수",15),
			new Member("박동수",25)
		
	};
		System.out.println(Arrays.toString(members)); //원래 toString(객체)은 객체를 가르키는 번지를 출력하는데, 재정의하여 toString을 객체안에 값을 출력시키도록 한다.
		
		//올림차순
		Arrays.sort(members);  
		System.out.println(Arrays.toString(members));
		
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));
}
	
	
}