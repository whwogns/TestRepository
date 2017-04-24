package study;

public class MultiCatchExample {

	public static void main(String[] args) {
		try{
			
		String data1 = null;
		String data2 = null;
		
			//���� 1
			data1 = args[0];
			data2 = args[1];
			
			//���� 2
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
			
		}catch(ArrayIndexOutOfBoundsException e){     //����1�� ���� catch
		
			System.out.println("���� �Ű����� ���� �����ϰų� ���ڷ� ��ȯ�� �� �����ϴ�.");
			
			
		}catch(Exception e){     //������ ���ܿ� ���� catch
			System.out.println("�˼����� ���� �߻�.");
		}finally{
			System.out.println("�ٽý����ϼ���");
		}
	}

}
