
package ch18.exam16;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
         byte[] data = "가나다".getBytes(); //이상태로 할때 데이타가 크다고 하면 // 출력시키는 속도가 느릴수있다.
         
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        
       
       for(int i=0;i<1000;i++){
            bw.write("가나다");  
       }
       
        
        bw.flush();
        osw.flush();
        os.flush();
        
        bw.close();
        osw.close();
        os.close();
        
        //프로그램에 가까운 순서대로 플러쉬와 클로즈해야함. 특히 클로즈 순서는 절대 바뀌면 안된다. 아직 데어터 전송전에 끊어져버릴수있으므로
    }
    
}
//버퍼의 효용성 테스트