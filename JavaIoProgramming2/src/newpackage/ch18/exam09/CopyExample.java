
package ch18.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyExample {

  
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    Reader is = new FileReader("src/ch18/exam09/test.txt");
    Writer os = new FileWriter("src/ch18/exam09/test2.txt") ;
    
    char[] c1 = new char[4];
    
    int readChars = -1;
    while(true){
        readChars = is.read(c1);
        if(readChars==-1) break;
        else{
        
        os.write(c1,0,readChars);
          }
    }
    
    os.flush();
    os.close();
    is.close();
     }

}

