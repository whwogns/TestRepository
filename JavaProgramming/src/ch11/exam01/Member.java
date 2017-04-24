package ch11.exam01;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id){
		this.id=id;
	}
	//Method
	@Override
	public boolean equals(Object obj) {    //equals 재정의.
		if(obj instanceof Member){
			Member target = (Member)obj; // 자식에 있는 obj를 가져오려면 타입변환해야함.
			if(id.equals(target)){
				return true;
		
			}
		}
			return false;
		}
	}


//if문 내부 다시 확인!