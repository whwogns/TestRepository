package ch11.exam09;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase(); //���ڿ��� �ҹ��ڷ� ��ȯ
		String lowerStr2 = str2.toLowerCase(); //���ڿ��� �ҹ��ڷ� ��ȯ
		System.out.println(lowerStr1);
		System.out.println(lowerStr2);
		System.out.println(lowerStr1.equals(lowerStr2));  // ���� ��� �ҹ��ڷ� ��ȯ�� �Ŀ� �������� ��½�Ŵ (boolean)
		
		
		
		System.out.println(str1.equalsIgnoreCase(str2));  // ���� ������ �ѹ��� �ϴ� �޼ҵ�. (�ҹ��ڳ� �빮�� ������� ���ڸ� ���Ѵ�)
	}

}
