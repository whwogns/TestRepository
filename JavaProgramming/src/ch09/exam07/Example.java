package ch09.exam07;

public class Example {
	
	public static void main(String[] args) {
		//����Ŭ������ �����ϰ� ��ü ����
		//B�� ����ؼ� ���ο� B2����� �װ��� ��ü����
		/*
		class B2 extends A.B{
			@Override
			void bMethod() {
				System.out.println("B2-bMethod()");
			}
		}
		A.B b = new B2();
		b.bMethod();
		*/
		//�̺κ��� ������ �ϴ� ���.
		
		A.B b = new A.B(){//�����ڸ� ȣ���ϴ°���. ��ü�� ����µ� B�� ���()�Ͽ� �ڽ��� ���� ����{}�ϰ� �ڽİ�ü�� �������� b�� ����. ( ==> (){} �ؼ����  )
			@Override
			void bMethod() {
				
			}
		};
		
		b.bMethod();
		
	}
}
