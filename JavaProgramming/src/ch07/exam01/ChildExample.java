package ch07.exam01;

public class ChildExample {

	public static void main(String[] args) {
		
		//�ڽ��� �θ�κ��� ��ӹ��� ���� ��°���
		Child child = new Child();
		System.out.println(child.lastName);
		child.sound();
		//�ڽ��� �ڽ��� ���� ��°���
		System.out.println(child.firstName);
		child.play();
	}

}
