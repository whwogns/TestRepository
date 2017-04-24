package ch18.exam25.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerExample {
    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        try {
            //ServerSocket 생성
            serverSocket =  new ServerSocket();  
            //포트와 바인딩
            serverSocket.bind(new InetSocketAddress(50001));    // (ip, 포트번호)  해당 아이피로만 들어오게 하겠다는 것. 아이피안쓰거나 localhost 쓰면 어느 아이피든 상관없다는것.   //bind : 서버의 포트와 연결되는것을 바인딩이라함.
            //연결기다리기
            Socket socket =  serverSocket.accept();   //클라이언트 연결되기 전까진 계속대기상태.
           //클라이언트의 정보 얻기
           InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
            System.out.println(isa.toString()); // InetSocketAddress 에 속한 메소드는 클라이언트의 정보를 불러오는 메소드가 있음,.
            System.out.println(isa.getHostName());
            //통신하기
            
            //연결끊기           
            socket.close();
        } catch (IOException ex) {
            //ServerSocket 닫기
            try { serverSocket.close(); } catch (IOException ex1) { }
        }
        
    }
}
