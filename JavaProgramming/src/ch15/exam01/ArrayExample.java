package ch15.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

	public static void main(String[] args) {
		Student[] array = new Student[3];
		array[0] = new Student("s1");
		array[1] = new Student("s2");
		array[2] = new Student("s3");
		//array[3] = new Student("s4");
		
		List<Student> list = new ArrayList<>();//리스트는 인터페이스이다. ArrayList라는 구현객체
		for(int i=0;i<100;i++){
			list.add(new Student("s"+i));
		}//리스트는 길이 제한없으므로 배열의 단점을 극복.
	
		list.remove(1);// 해당 인덱스가 지워지면 자동으로 앞으로 채워짐. 배열은 일일이 널인 곳을 찾아서 넣어줘야 하는데 그런 단점을 해결함.
	}

}
