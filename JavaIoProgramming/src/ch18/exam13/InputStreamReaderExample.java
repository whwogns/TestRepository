
package ch18.exam13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
        
        
//        InputStream is = System.in;
//       InputStreamReader isr = new InputStreamReader(is);  // 보조스트림을 이용하여 한문자를 읽게끔 변환시켜줌.
//        int data = is.read(); //이상태로만 두면 1바이트만 읽으므로 문자가 깨지는 경우가 생김./       
//        System.out.println((char)data);

        InputStream is = new FileInputStream("src/ch18/exam13/test2.txt");
        InputStreamReader isr = new InputStreamReader(is,"EUC-KR");  // 디폴트로 ,뒤에 UTF-8임. 다른 문자 인코딩을 설정할 수 있음.
        int data = isr.read();
        System.out.println((char)data);
    }
}
