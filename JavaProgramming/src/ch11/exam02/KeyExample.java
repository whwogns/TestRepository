package ch11.exam02;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		HashMap hashMap = new HashMap();//임포트 요함
		
		Key k1 = new Key(10);
		Member m1 = new Member("blue");
		hashMap.put(k1, m1);
		
		Key k2 = new Key(10);
		Member m2 = new Member("white");
		hashMap.put(k2, m2);
		
		
		System.out.println(hashMap.size());
		System.out.println(m2);//해시맵에 있는 값을 출력하려면? 해시코드말고
	}

}
