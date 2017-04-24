package ch15.exam07;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		//TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());//원래순서와 반대로 트리맵에 저장시킴.
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("홍길동",45));
		set.add(new Person("감자바",25));
		set.add(new Person("박지원",31));
		
	
		for(Person p : set){
			System.out.println(p.getName()+"("+p.getAge()+")");
		}
		//바로 출력하면 올림차순이다.
		
	}

}
