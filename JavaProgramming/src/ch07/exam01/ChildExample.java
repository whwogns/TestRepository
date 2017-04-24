package ch07.exam01;

public class ChildExample {

	public static void main(String[] args) {
		
		//자식이 부모로부터 상속받은 것을 출력가능
		Child child = new Child();
		System.out.println(child.lastName);
		child.sound();
		//자식의 자신의 것을 출력가능
		System.out.println(child.firstName);
		child.play();
	}

}
