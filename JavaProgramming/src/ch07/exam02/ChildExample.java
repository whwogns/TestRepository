package ch07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		
		//�ڽ��� �θ�κ��� ��ӹ��� ���� ��°���
		Child child = new Child("��","�浿");
		System.out.println(child.lastName);
		child.sound();
		//�ڽ��� �ڽ��� ���� ��°���
		System.out.println(child.firstName);
		child.play();
	}

}
