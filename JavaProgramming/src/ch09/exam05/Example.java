package ch09.exam05;

public class Example {

	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();   // A������ ���� ����� A�� ���� B�� ����// �̷� ��� �ٵ� �平.       /// Ŭ������ �ν��Ͻ��϶�
		
		Main.C = new A.C(); //����ƽ�� �ֱ⶧���� �̷��� �� �� �ִ�. //�̷��� ���̴� ��찡 �ξ�����.      /// Ŭ������ ����ƽ�϶�

	}
}
