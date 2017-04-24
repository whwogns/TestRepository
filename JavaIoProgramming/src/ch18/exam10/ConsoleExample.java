
package ch18.exam10;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ConsoleExample {
    
    public static void main(String[] args) throws IOException{
       // int keycode = System.in.read();
        
        InputStream is = System.in;
       // int keycode = is.read();
       
       
       
       //how1     = 키보드 입력한대로 출력
       byte[] keycodes = new byte[10];
       int readBytes = is.read(keycodes);
        //System.out.println(Arrays.toString(keycodes));
       String str = new String(keycodes,0,readBytes-2 ); //라인피드 가 더 들어가니 -1 (캐리지 리턴까지 있다면 -2)을 써주어야한다.
        System.out.println(str);
       
        
        //how2 
        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.nextLine();
        System.out.println(str2);
        
        
        
        //how3
        Console console = System.console();
        String str3 = console.readLine();
    }
    
}
// 키보드 입력한대로 출력하는 방법 3가지 
//how1을 잘 알아두고 how2가 가장 효율적이긴 하다.