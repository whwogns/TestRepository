package ch14.exam05;

public class MethodReferenceExample {

	public static void main(String[] args) {
		method1(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				
				return a.equals(b);
			}
		});
		
		
		//���� �ڵ� ���̱� ���ٽ�
		
		method1((a,b)->{return a.equals(b);});
		method1((a,b)-> a.equals(b));
		method1(String :: equals);//�̿� ���� �ڵ��� �޼ҵ�� �ν��Ͻ��� �͵� �ǰ� ����ƽ�� �͵� �Ǵµ�, 
		//�����Ϸ��� ������ ���� �ڵ带 ����, �����϶��� �Ű������� �޴´�/ �ν��Ͻ���� ���� a.equals(�Ű���)���� �ؼ�.
		
	}

	public static void method1(FunctionalInterface1 i){
		boolean result = i.method("Java", "java");
		System.out.println(result);
	}
}
