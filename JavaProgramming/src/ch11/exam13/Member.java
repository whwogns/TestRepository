package ch11.exam13;

public class Member implements Comparable<Member> {     //<>의미는 member끼리 비교하란뜻.
 	private String name;
 	private int age;
	
	public Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return name+"("+age+")";//네임과 에이지 값자체가 나오도록 toString을 재정의 한것이다. 
		
	}

	@Override
	public int compareTo(Member o) {
		//return name.compareTo(o.name);//기준객체가 앞에있으면 음수 비교객체보다 뒤에 위치하면 양수.를 리턴하도록 재정의한것.
		
		/*
		return age-o.age;
		
		if(age<0.age){
			return -1;
		}else if(age == o.age){
			return 0;
		}else{
			return 1;
		}
		*/
		
		return Integer.compare(age, o.age);
	}
		
}


