package ch11.exam13;

public class WrapperEqualsExample {

	public static void main(String[] args) {
		Integer v1 = 1000;  // =new Integer(10)
		Integer v2 = 1000; // =new Integer(10)
		
		System.out.println(v1 == v2); //��ü ��
		System.out.println(v1.intValue()==v2.intValue()); // ��ü�ȿ� ���� ������ ��
		System.out.println(v1.equals(v2)); // �����ǵ� �������Ƿ� ���� ���ϴ°���.
	}

}
//* �⺻Ÿ���� �ƴ��̻� '=='�� ���� ��������! ������ ����� ���� ��찡 �ִ�. �����ϸ� '=='���� �ʵ����ϰ� .equals()�� �̿��Ѵ�.