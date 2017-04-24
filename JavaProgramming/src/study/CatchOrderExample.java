package study;

public class CatchOrderExample {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try{
			
			//���� 1
			data1 = args[0];
			data2 = args[1];
			
			//���� 2
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1+"+"+data2+"="+result);
			
			
		}catch(ArrayIndexOutOfBoundsException e){     //����1�� ���� catch
		
			System.out.println("[������]");
			System.out.println("java ArrayIndexOutOfBoundsExceptionExample2");
			System.out.println("��1 ��2");
			
			
		}catch(Exception e){     //����2�� ���� catch
			System.out.println("���ڷ� ��ȯ�� �� �����ϴ�.");
		}finally{
			System.out.println("�ٽý����ϼ���");
		}
	}

}

//���� ������� ����2�� ���ؼ� ����ó���� ���� �ʴ� ����.  (�������� ����)
