package ch07.exam04;

public class ChildExample {

	public static void main(String[] args) {
		
		//�ڽ��� �θ�κ��� ��ӹ��� ���� ��°���
		Child child = new Child("��","�浿");
		System.out.println(child.lastName);
		child.sound();
		//�ڽ��� �ڽ��� ���� ��°���
		System.out.println(child.firstName);
		
		child.play();
		
		child.parentSound();//�̷��� �ϸ� �θ���嵵 ����� �� �ִ�. Child�� �޼ҵ带 �������־����Ƿ�
	}
//ChildExample������ �θ��� ���带 ȣ���Ҽ�����. �ڽ��� ���忡 �������⶧����./ �� Child������ �θ��� ���带 ȣ���Ҽ��ִ�.,
}
