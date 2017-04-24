package ch18.exam19;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LineDataExample {
    public static void main(String[] args) throws IOException {
//        FileOutputStream fos = new FileOutputStream("src/ch18/exam19/test.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos);
//        osw.write("abcde\r\n");
//        osw.write("12345\r\n");
//        osw.write("가나다라마");
//        osw.flush();
//        fos.flush();
//        osw.close();
//        fos.close();

        FileOutputStream fos = new FileOutputStream("src/ch18/exam19/test.txt");      // 위와 달리 프린트스프림을 이용하면 편리하게 행단위로 데이터 출력가능. 
        //PrintStream out = new PrintStream(fos);       
        PrintWriter out = new PrintWriter(fos); //위와 같다.
        out.println("abcde");
        out.println("12345");
        out.print("가나다라마");
        out.flush();
        fos.flush();
        out.close();
        fos.close();
        
        
        FileInputStream fis = new FileInputStream("src/ch18/exam19/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);  //행단위로 읽을땐 BufferedReader 로 읽는게 편함.
        
        
        while(true){
            String line = br.readLine();
            if(line == null) break;   //스트링이므로 더이상 읽을게 없으면 null을 리턴함.
            System.out.println(line);
        }
        br.close();
        isr.close();
        fis.close();
        
    }
}
