
package ch18.exam14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam14/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        
        
            osw.write("가");   // 보조스트림이 있으니 바이트로 변환할 필요없이 막바로 "가"라는 문자를 입력시켜줄수있다.
            osw.flush();
            osw.close();
            
//        byte[] data = "가".getBytes();   //'가'라는 문자의 바이트를 얻기위해서 getByte()로 하여 바이트를 얻어 배열에 저장시킴. 막바로 '가'를 write()에 넣어줄순없다. 타입이 안맞으니      
//        os.write(data);
//        os.flush();
//        os.close();
        
    }
}
