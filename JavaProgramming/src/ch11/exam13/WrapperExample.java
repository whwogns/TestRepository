package ch11.exam13;

public class WrapperExample {

	public static void main(String[] args) {
		
		int v1 = 10;
		
		Integer v2 = 10; //10�������� �Ǵ°� �ƴ϶� ��Ƽ����ü�� �����Ͽ� �ű⿡ 10�� �����Ѱ��̰� v2���� �� ��ü�� ������ �Էµ�.  //����ڽ�
		int v3 = v2; //v2��ü�ȿ� �����Ͱ��� 10�� ������ ��Ʈ������ v3�� �־��ش�.   //�����ڽ�
		
		method1(3); //3�� ������ �ִ� ��ü�� �����Ͽ� �޼ҵ忡 ����ȴ�.//����ڽ�
		int v4 = method2();//���� ��ڽ�
	}
	
	 public static void method1(Integer obj){};
	 public static Integer method2(){return 1;}//��Ƽ���� �ڵ����� ��Ʈ������ �ٲپ v4�� �����.
}

