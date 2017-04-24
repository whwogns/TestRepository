package ch18.exam26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {
    public static void main(String[] args) throws IOException {
        
            //스레드풀 생성
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            
            
            for(int i=0;i<1000;i++){
            //작업 생성 코드
            Runnable task = ()->{
                System.out.println(Thread.currentThread().getName()+": 작업처리");       
            };

            //작업 처리 지시(작업큐에 넣기) 넣었다고 스레드로 모두 바로 들어가진 않고 순서에 맞춰 스레드로 처리들어감.// 작업큐에 넣기만하면 스레드가 알아서 갖다가 처리함.
            executorService.submit(task);
            }
            
            //스레드풀 종료  
            System.in.read(); //키보드 누르면 다음 셧다운실행된다는 것.           
            executorService.shutdown();
            
    }
}
