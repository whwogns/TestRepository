package ch11.exam10;

public class StringSplitExample {
	public static void main(String[] args){
		String text = "홍길동&이수홍,박연수,김자바-최명호";
		
		
		String[] names = text.split("&|,|-");  
		
		for(String name : names){  // 향상된 for문 names배열의 데이터를 name변수로 하나씩 넣어준다. 그러다 names배열에 데이터가 없으면 false가되서 for문을 벗어남.
			System.out.println(name);
		}
	}
}
