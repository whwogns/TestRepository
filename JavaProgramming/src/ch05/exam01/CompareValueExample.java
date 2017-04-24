package ch05.exam01;

public class CompareValueExample {
	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 10;
		System.out.println(v1 == v2); // v1 v2값이 같으냐
		
		int[] v3 = {10};
		int[] v4 = {10};//  =v3라면 true가 된다. 왜냐면 같은 주소가 되므로
		System.out.println(v3 == v4); // v3 v4 값이 같으냐를 묻는게 아니라 배열이 같으냐를 묻는것.
		
		String v5 = "Java";
		String v6 = "Java";
		System.out.println(v5 == v6);//같은 객체를 가르킨다고 볼수 있다. (문자열 리터럴이 동일하다면, 그것을string을 공유하게 됨)
	
		String v7 = new String ("Java");
		String v8 = new String ("Java");
		System.out.println(v7.equals(v8)); //new는 새로운 번지를 개설하라는 뜻이므로 동일한 리터럴이지만 둘은 다른 주소가됨.
	}

}
