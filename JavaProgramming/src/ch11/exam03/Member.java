package ch11.exam03;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id){
		this.id=id;
	}
	//Method
	@Override
	public String toString() {   //tostring을 재정의한것임.
		return id;
	}
	
	}


//if문 내부 다시 확인!