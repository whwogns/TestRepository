
package ch18.exam06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class ReadExample {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = ReadExample.class.getResource("test.txt").getPath();
        Reader reader = new FileReader(path); //텍스트니까 파일리더쓰는거임
        
        String str ="";
        int data = -1;
        while(true){
            data = reader.read();
            if(data == -1) break;
            str +=(char)data;
         
        }
        reader.close();
        System.out.println(str);
        
    }
}
