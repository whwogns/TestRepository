package ch18.exam22;

import java.io.Serializable;

public class Member implements Serializable{
    //Field
    private static final long serialVersionUID = 1;
    
    private String mname;
    private int age;
    
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
