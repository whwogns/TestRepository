package ch18.exam20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {
    //전송된 객체를 읽는 프로그램
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/ch18/exam20/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
       Member member = (Member) ois.readObject();  //저장된 파일은 object타입이므로 읽기위해선 Member타입으로 변환해야한다.
        System.out.println(member.getAge());
        System.out.println(member.getMname());
        
        ois.close();
        fis.close();
        
        
        
    }
}
