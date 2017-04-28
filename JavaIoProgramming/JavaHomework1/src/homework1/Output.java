
package homework1;

import java.io.IOException;
import java.io.InputStream;

public class Output {
    public static void main(String[] args) throws IOException {
        
        InputStream is = System.in;

        
        int readByteNo;
        byte[] readBytes = new byte[10];
        while(true){
			readByteNo=is.read(readBytes);
			if(readByteNo==-1)
				break;
			
			System.out.print(new String(readBytes, 0, readByteNo));
        }
    }
}
