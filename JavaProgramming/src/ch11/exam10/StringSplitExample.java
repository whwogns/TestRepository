package ch11.exam10;

public class StringSplitExample {
	public static void main(String[] args){
		String text = "ȫ�浿&�̼�ȫ,�ڿ���,���ڹ�-�ָ�ȣ";
		
		
		String[] names = text.split("&|,|-");  
		
		for(String name : names){  // ���� for�� names�迭�� �����͸� name������ �ϳ��� �־��ش�. �׷��� names�迭�� �����Ͱ� ������ false���Ǽ� for���� ���.
			System.out.println(name);
		}
	}
}
