package ch06.exam09;

public class Member {
	String name;
	final String ssn;//final 최종적인 것이니 더이상 바꿀수 없음. 생성자를 통해서만 딱 한번만 변경기회를 주고 그후에는 변경할수없다.
	//이때 여기에 값을 먼저 넣어버리면 그후에 생성자에서 한번조차도 바꿀수없게된다.
	Member(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
}
