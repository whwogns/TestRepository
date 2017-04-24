package ch06.exam04;

public class Tire {
//FIELD
	String location;
	//Constructor
	Tire(String location){
	this.location= location;//하나라도 생성자라도 있으면 자동으로 생성자가 생성안됨.
	}
	//Method
	void roll(){
		System.out.println(location + "바퀴가 돌아감");
	}
}
