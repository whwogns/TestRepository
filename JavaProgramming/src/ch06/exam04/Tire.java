package ch06.exam04;

public class Tire {
//FIELD
	String location;
	//Constructor
	Tire(String location){
	this.location= location;//�ϳ��� �����ڶ� ������ �ڵ����� �����ڰ� �����ȵ�.
	}
	//Method
	void roll(){
		System.out.println(location + "������ ���ư�");
	}
}
