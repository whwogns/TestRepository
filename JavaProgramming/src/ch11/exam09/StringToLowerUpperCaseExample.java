package ch11.exam09;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase(); //문자열을 소문자로 변환
		String lowerStr2 = str2.toLowerCase(); //문자열을 소문자로 변환
		System.out.println(lowerStr1);
		System.out.println(lowerStr2);
		System.out.println(lowerStr1.equals(lowerStr2));  // 둘을 모두 소문자로 변환한 후에 같은지를 출력시킴 (boolean)
		
		
		
		System.out.println(str1.equalsIgnoreCase(str2));  // 위의 과정을 한번에 하는 메소드. (소문자나 대문자 관계없이 문자를 비교한다)
	}

}
