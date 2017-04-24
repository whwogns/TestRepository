package ch11.exam01;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		System.out.println(m1 == m2);  //m1객체와 m2객체가 같냐는 것이므로 번지비교이므로 이는 FALSE
		System.out.println(m1.equals(m2));    //Object에서의 equals는 번비비교. // equals를 재정의하여 논리적 데이터 비교가 가능한지 재정의가능
		
		String s1 ="abc";
		String s2 = new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
				
		
	}

}
