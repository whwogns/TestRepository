package ch06.exam08;

public class calculator {
	 	static calculator singleton = new calculator();
	private calculator(){//Ŭ�����ۿ��� �� �ҷ�����. ȣ��ȵ�. �갡 �ڱ⸸ ��������.
		
	}
	
	static calculator getInstance(){//�̶� ����ƽ ���� ������ �����̺� calculator�ε� ����� �������� ��ü�� �ʿ�������ʴ� static�� ����ϴ°�
		
		return singleton;
	}
}
