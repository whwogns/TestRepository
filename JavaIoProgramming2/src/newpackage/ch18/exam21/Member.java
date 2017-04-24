package ch18.exam21;

import java.io.Serializable;

public class Member implements Serializable{
    //Field
    
    
    private String mname;
    private int age;
    public static String nation = "한국";             // 스태틱은 직렬화의 대상이 되지 않는다.
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
