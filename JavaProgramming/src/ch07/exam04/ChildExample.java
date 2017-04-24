package ch07.exam04;

public class ChildExample {

	public static void main(String[] args) {
		
		//자식이 부모로부터 상속받은 것을 출력가능
		Child child = new Child("김","길동");
		System.out.println(child.lastName);
		child.sound();
		//자식의 자신의 것을 출력가능
		System.out.println(child.firstName);
		
		child.play();
		
		child.parentSound();//이렇게 하면 부모사운드도 출력할 수 있다. Child에 메소드를 생성해주었으므로
	}
//ChildExample에서는 부모의 사운드를 호출할수없다. 자식의 사운드에 가려지기때문에./ 단 Child에서는 부모의 사운드를 호출할수있다.,
}
