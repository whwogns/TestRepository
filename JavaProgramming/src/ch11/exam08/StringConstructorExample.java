package ch11.exam08;

public class StringConstructorExample  {

	public static void main(String[] args) throws Exception {
		String s1 = "abc";
		String s2 = new String("abc");
	
		
		char[] charArray={'a','b','c'};
		String s3 = new String(charArray);
		
		byte[] byteArray ={49,50,51}; //아스키코드 실제 입력되는 것은 키코드로 입력됨.
		String s4 = new String(byteArray); // 이렇게 하면 전체 배열의 내용을 모두 문자열로 출력시킴.vvvvvvvvvvvvvvvvvvvvvvvvvv  배열전체의 키코드를 모두 문자열로~
		System.out.println(s4);
		/*
		byte[] inputData = new byte[100];
		//int keyCode = System.in.read(); /// 키코드를 하나씩 읽고 해당 값으로 출력시켜줌.
		int readByteNo = System.in.read(); //배열에서 채워진 바이트 갯수. 
		String strData = new String(inputData,0,readByteNo-2); // 0부터 5까지 인덱스까지의 키코드를 문자열로 출력해줌.  vvvvvvvvvvvvvvvvvvvvvvvvvv  배열중 일부인덱스까지만 키코드를 문자열로~
		//(바이트배열에 채워진 키코드에 대하여, 0 인덱스부터, (전제바이트갯수-2)이전까지(=length) 문자열로 출력해줌.)
		*/
		
		byte[] byteArray2 = {49,50,51,52,53,54,55};
		
		String strData2 = new String(byteArray2,3,3);
		System.out.println(strData2);
	}

}
