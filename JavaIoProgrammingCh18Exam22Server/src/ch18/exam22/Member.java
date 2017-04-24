package ch18.exam22;

import java.io.Serializable;

public class Member implements Serializable{
    //Field
    private static final long serialVersionUID = 1;  // 필드값이 서버랑 클라이언트와 다르면 예외발생. 일치하는 것만 전송되도록 해보자.  serialVersionUID가 같은 값이라면 같은 객체 같은 타입으로 간주하여 전송가능.
    
    private String mname;
    private int age;
    private String job;
    
    //Constructor
    public Member(int age, String mname){
        this.age=age;
                this.mname=mname;
    }
    //Method

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}
