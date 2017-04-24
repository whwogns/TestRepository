package ch11.exam05;

public class Member {
	//Field
	private String id;
	//Constructor
	public Member(String id){
		this.id=id;
		}
	//Method
		@Override
		public String toString() {  
		return id;
		}
		
		@Override
		protected void finalize() throws Throwable {
			System.out.println(id+"가 제거됨");             //재정의한 것으로써 , 쓰레기가 제거되기 전에 호출한번하고 죽는것임,.
		}
	
	}


