
package homework1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Output {
    public static void main(String[] args) throws IOException {
        
        InputStream is = System.in;
        OutputStream os = System.out;
        
        int readByteNo;
        byte[] readBytes = new byte[10];
        while((readByteNo=is.read(readBytes)) !=-1){
            os.write(readBytes, 0, readByteNo);
        }
    }
}
