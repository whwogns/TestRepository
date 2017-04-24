package ch07.exam01;

public class Child extends Parent {
	
	//Field
	String firstName ="자바";
	//Constructor
	public Child(){
		super(); //부모생성자부터 생성.//부모의 생성자중에서 매개변수없는 생성자를 실행하라는뜻. 부모 생성자에 매개변수없는것이 없다면 super()로는 호출 안됨.
		System.out.println("Child객체생성");
	}
	//Method
	void play(){
		System.out.println("놀아요");
	}
	
}
