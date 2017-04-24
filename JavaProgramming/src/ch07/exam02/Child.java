package ch07.exam02;

public class Child extends Parent {
	
	//Field
	String firstName ="자바";
	//Constructor
	Child(String lastName, String firstName){
		//super();//Parent에는 매개변수있는 생성자만 있으니 불러올수 없다.
		super(lastName);//그러므로 매개변수에 값을 넣어준 형태가 되야한다.//super는 맨위에 위치해야한다. 
		// super()가 없어도 컴파일러가 이것을 추가시켜준다. 근데 Parent객체에 매개변수가 있는 생성자뿐이므로 super에도 직접 매개변수를 넣어줘야한다. 
		this.firstName=firstName;
	}
	//Method
	void play(){
		System.out.println("놀아요");
	}
	
}
