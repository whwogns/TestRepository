package ch18.exam23;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable {
    private int membershipNo;
    private String grade;
    
   public VVIP(){}
    
    public VVIP(int membershipNo, String grade, String name, int age) {
        super(name, age);
        this.membershipNo = membershipNo;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(int membershipNo) {
        this.membershipNo = membershipNo;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeUTF(getName());   // 부모의 이름을 저장.      //이와 같은 코드로 부모의 필드를 별도로 serializable해주는 것임.
        out.writeInt(getAge());
        out.defaultWriteObject();    //자기자신의 필드를 직렬화.
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        setName(in.readUTF());   // 읽고 부모의 이름 세팅      //부모의 필드를 별도로 읽어들이는 코드작성
        setAge(in.readInt());
        in.defaultReadObject();   //자신의 필드를 역직렬화
    }
            //반드시 프라이빗이어야함.
        
}
