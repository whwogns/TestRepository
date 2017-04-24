package ch18.exam25.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientExample1 {
    public static void main(String[] args) {
        
        Socket socket = null;
        
        try {
            //how1
            //socket = new Socket("192.168.3.30", 50001); //서버의 ip를 준다. 서버에 접근하는 것임.
            
            //how2
            socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.3.30",50001));
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(!socket.isClosed()){
             try { socket.close(); } catch (IOException ex) { }
        }
    }

}
