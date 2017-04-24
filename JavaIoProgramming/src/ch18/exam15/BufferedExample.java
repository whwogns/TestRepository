
package ch18.exam15;

import ch18.exam16.*;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
         byte[] data = "가나다".getBytes(); //이상태로 할때 데이타가 크다고 하면 // 출력시키는 속도가 느릴수있다.
         
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
       
       long startTime = System.nanoTime();
       
       for(int i=0;i<1000;i++){
       bos.write(data);  
       }
       
       long endTime = System.nanoTime();
       System.out.println(endTime - startTime);
        
        bos.flush();
        bos.close();
    }
    
}
//버퍼의 효용성 테스트