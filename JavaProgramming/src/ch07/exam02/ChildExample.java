package ch07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		
		//자식이 부모로부터 상속받은 것을 출력가능
		Child child = new Child("김","길동");
		System.out.println(child.lastName);
		child.sound();
		//자식의 자신의 것을 출력가능
		System.out.println(child.firstName);
		child.play();
	}

}
