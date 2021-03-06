package ch18.exam23;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {
    //전송된 객체를 읽는 프로그램
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/ch18/exam23/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
       VVIP vvip =(VVIP) ois.readObject();
        System.out.println(vvip.getMembershipNo());
        System.out.println(vvip.getName());
        System.out.println(vvip.getAge());
        System.out.println(vvip.getGrade());
     
        ois.close();
        fis.close();
        
        
        
    }
}
