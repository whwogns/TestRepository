package ch11.exam01;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		
		System.out.println(m1 == m2);  //m1��ü�� m2��ü�� ���Ĵ� ���̹Ƿ� �������̹Ƿ� �̴� FALSE
		System.out.println(m1.equals(m2));    //Object������ equals�� �����. // equals�� �������Ͽ� ���� ������ �񱳰� �������� �����ǰ���
		
		String s1 ="abc";
		String s2 = new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
				
		
	}

}
