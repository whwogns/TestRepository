package ch09.exam04;

public class A {
	//Field
	int field;
	//Constructor
	//Method
	//Nested Class (��ø ��� Ŭ����)
	class B {
		//Field
		int field;
		//Constructor
		//Method
		void method(){
			field=10;     // �̶��� �ʵ�� ���尡��� B�� �ʵ��̴�.(=> this.field=10;)
			A.this.field=10; // B�� �ʵ� ���� A�� �ʵ带 ���پ��� ���̴� �����.
		}
		
	} 
}



