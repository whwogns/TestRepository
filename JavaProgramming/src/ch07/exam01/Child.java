package ch07.exam01;

public class Child extends Parent {
	
	//Field
	String firstName ="�ڹ�";
	//Constructor
	public Child(){
		super(); //�θ�����ں��� ����.//�θ��� �������߿��� �Ű��������� �����ڸ� �����϶�¶�. �θ� �����ڿ� �Ű��������°��� ���ٸ� super()�δ� ȣ�� �ȵ�.
		System.out.println("Child��ü����");
	}
	//Method
	void play(){
		System.out.println("��ƿ�");
	}
	
}
