package ch05.exam01;

public class CompareValueExample {
	public static void main(String[] args) {
		int v1 = 10;
		int v2 = 10;
		System.out.println(v1 == v2); // v1 v2���� ������
		
		int[] v3 = {10};
		int[] v4 = {10};//  =v3��� true�� �ȴ�. �ֳĸ� ���� �ּҰ� �ǹǷ�
		System.out.println(v3 == v4); // v3 v4 ���� �����ĸ� ���°� �ƴ϶� �迭�� �����ĸ� ���°�.
		
		String v5 = "Java";
		String v6 = "Java";
		System.out.println(v5 == v6);//���� ��ü�� ����Ų�ٰ� ���� �ִ�. (���ڿ� ���ͷ��� �����ϴٸ�, �װ���string�� �����ϰ� ��)
	
		String v7 = new String ("Java");
		String v8 = new String ("Java");
		System.out.println(v7.equals(v8)); //new�� ���ο� ������ �����϶�� ���̹Ƿ� ������ ���ͷ������� ���� �ٸ� �ּҰ���.
	}

}
