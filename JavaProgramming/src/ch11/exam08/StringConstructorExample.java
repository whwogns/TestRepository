package ch11.exam08;

public class StringConstructorExample  {

	public static void main(String[] args) throws Exception {
		String s1 = "abc";
		String s2 = new String("abc");
	
		
		char[] charArray={'a','b','c'};
		String s3 = new String(charArray);
		
		byte[] byteArray ={49,50,51}; //�ƽ�Ű�ڵ� ���� �ԷµǴ� ���� Ű�ڵ�� �Էµ�.
		String s4 = new String(byteArray); // �̷��� �ϸ� ��ü �迭�� ������ ��� ���ڿ��� ��½�Ŵ.vvvvvvvvvvvvvvvvvvvvvvvvvv  �迭��ü�� Ű�ڵ带 ��� ���ڿ���~
		System.out.println(s4);
		/*
		byte[] inputData = new byte[100];
		//int keyCode = System.in.read(); /// Ű�ڵ带 �ϳ��� �а� �ش� ������ ��½�����.
		int readByteNo = System.in.read(); //�迭���� ä���� ����Ʈ ����. 
		String strData = new String(inputData,0,readByteNo-2); // 0���� 5���� �ε��������� Ű�ڵ带 ���ڿ��� �������.  vvvvvvvvvvvvvvvvvvvvvvvvvv  �迭�� �Ϻ��ε��������� Ű�ڵ带 ���ڿ���~
		//(����Ʈ�迭�� ä���� Ű�ڵ忡 ���Ͽ�, 0 �ε�������, (��������Ʈ����-2)��������(=length) ���ڿ��� �������.)
		*/
		
		byte[] byteArray2 = {49,50,51,52,53,54,55};
		
		String strData2 = new String(byteArray2,3,3);
		System.out.println(strData2);
	}

}
