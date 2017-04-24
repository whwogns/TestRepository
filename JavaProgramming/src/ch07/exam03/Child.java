package ch07.exam03;

public class Child extends Parent {
	
	//Field
	String firstName ="자바";
	//라스트네임을 어차피 상속되기 때문에 굳이 여기서 선언을 또할필요없다.
	//Constructor
	Child(String lastName, String firstName){
		//super();//Parent에는 매개변수있는 생성자만 있으니 불러올수 없다.
		super(lastName);//그러므로 매개변수에 값을 넣어준 형태가 되야한다.//super는 맨위에 위치해야한다. 
		// super()가 없어도 컴파일러가 이것을 추가시켜준다. 근데 Parent객체에 매개변수가 있는 생성자뿐이므로 super에도 직접 매개변수를 넣어줘야한다. 
		this.firstName=firstName;
	}
	//Method
	void play(){
		System.out.println("놀아요");//메소드같은경우는 상속받더라도 부모메소드를 자식에 맞게 수정할 필요가 있는 경우도 있다. 이를 메소드 오버라이딩이라 함.
	}
	@Override //어노테이션 : 아래와 같은 메소드가 부모에 실제 메소드가 있는지 컴파일러에게 확인해달라고 하는것. 
	//자바코드는 아니다. 내부소스에서는 자바코드가 짜여있고 그것을 갖다가 쓰는것임.//어노테이션이 없으면 그냥 새로운 메소드로 받아들임.
	void sound(){     //오버라이딩 조건 : 1. 부모의 메소드 코드(void sound(){} - 리턴타입)와 같아야 한다. 2. 부모의 접근제한자보다 넓은 범위의 접근제한자를 써야한다.
		System.out.println("낄낄");
	}
	//컨트롤+스페이스 를 하면 부모에서 이미 정의된 메소드목록을 볼수있고 그것을 불러올수있다. 그것을 재정의(오버라이딩)할수있다.
	
}
