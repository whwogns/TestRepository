package ch09.exam03;

public class A {
	//Field
	//Constructor
	
	A(){ 
		int localVariable =2; //���ú����� ���̳��� �ٿ��� ��. 1.8���� �������� final�� �ٿ��� �ϳ� 1.8���������� ������. // �� �ڹ� 1.8������ ���ú����������� ����Ʈ�� final�� �پ�����.
		//���� Ŭ����
		class D {
			//Field
			//Constructor
			//Method
			void dMethod(){
				int result = localVariable + 8;
				//localVariable =10; //final�� �پ����� ������Ұ� --- 
			}
		}
	}
	//Method
	void method(){
		//����Ŭ����
		class E{}
	}
	
	//Nested Class (��ø ��� Ŭ����)
	class B {} // ����ƽ�� �Ⱥپ����� A��ü���̴� A���� ���ٸ���.  // A�� �������� B�� �ǹ̾��� ��쿡 ����
	static class C{} //AŬ����(A��ü) ���̵� C��밡��  �긦 �� ���̾�.  // A�� ���� ��������� A���� �����Ѱ��̶�� ���� �˸��� ���� ����.
}
//������ �ȿ� �޼ҵ�ȿ� ���� Ŭ���� �� �������ִ�.//�ٵ� �̷��Դ� �� ������ ����.

