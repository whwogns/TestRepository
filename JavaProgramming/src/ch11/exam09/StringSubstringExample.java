package ch11.exam09;

public class StringSubstringExample {

	public static void main(String[] args) {
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6);  //0에서 6앞까지라는 뜻.
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
	}

}
