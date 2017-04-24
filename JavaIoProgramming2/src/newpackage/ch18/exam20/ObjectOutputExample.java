package ch18.exam20;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream fos =  new FileOutputStream("src/ch18/exam20/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        Member member = new Member(30,"감자바");
        
        oos.writeObject(member); // 괄호안에는 직렬화 할수있는 객체만 와야함.  
        //Serializable 을 구현한 객체만 직렬화할 수있다. //개발자가 입출력 외부로 보내도 된다는 허가의 의미로 implements Serializable이 붙은 객체는 가능함.//인터페이스로서 의미는 없다.
        
        oos.flush();
        fos.flush();
        oos.close();
        fos.close();
        
        
    }

}
