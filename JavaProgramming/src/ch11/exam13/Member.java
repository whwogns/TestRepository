package ch11.exam13;

public class Member implements Comparable<Member> {     //<>�ǹ̴� member���� ���϶���.
 	private String name;
 	private int age;
	
	public Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return name+"("+age+")";//���Ӱ� ������ ����ü�� �������� toString�� ������ �Ѱ��̴�. 
		
	}

	@Override
	public int compareTo(Member o) {
		//return name.compareTo(o.name);//���ذ�ü�� �տ������� ���� �񱳰�ü���� �ڿ� ��ġ�ϸ� ���.�� �����ϵ��� �������Ѱ�.
		
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


