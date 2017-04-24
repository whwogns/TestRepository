package ch18.exam25.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {
    public static void main(String[] args)  {
        ServerSocket serverSocket = null;
        try {
            //ServerSocket 생성
            serverSocket =  new ServerSocket();  
            //포트와 바인딩
            serverSocket.bind(new InetSocketAddress(50001));    // (ip, 포트번호)  해당 아이피로만 들어오게 하겠다는 것. 아이피안쓰거나 localhost 쓰면 어느 아이피든 상관없다는것.   //bind : 서버의 포트와 연결되는것을 바인딩이라함.
            //연결기다리기
            
            
            while(true){    // 계속 통신하기 위함.
            Socket socket =  serverSocket.accept();   //클라이언트 연결되기 전까진 계속대기상태.
           
            //통신하기
            InputStream is = socket.getInputStream();
            byte[] data = new byte[100];          
            int readBytes = is.read(data);  // 클라이언트에서 데이터가 올것이라 기대하는중 클라이언트가 죽으면 여기서 에러발생//서버는 reset되어 비정상 종료됨
            
            if(readBytes == -1){
               throw new IOException("클라이언트가 정상 종료됨");   // 클라이언트가 데이터를 안보내면 여기서 에러발생.//서버는 정상 종료됨.
            }
            String strData = new String(data, 0, readBytes, "UTF-8");
            System.out.println("받은 데이터:"+strData);
            
            
            OutputStream os = socket.getOutputStream();
            data = strData.getBytes("UTF-8");
            os.write(data);
            os.flush();
             System.out.println("데이터보내기 성공");
            
            //연결끊기           
            socket.close();
            }
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        //ServerSocket이 50001을 현재 사용하고 있느냐?를 묻는것이고 50001을 사용하고 있다면 더이상 사용하지 말라 는 것.// 정확한것은 serverSocket이 널인지도 묻는것이 맞다.
        if(serverSocket != null && !serverSocket.isClosed())
          //ServerSocket 닫기(포트 50001을 해제 한다)
            try { serverSocket.close(); } catch (IOException ex1) { }
        }
        
    }

