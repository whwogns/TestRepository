package ch07.exam02;

public class Child extends Parent {
	
	//Field
	String firstName ="�ڹ�";
	//Constructor
	Child(String lastName, String firstName){
		//super();//Parent���� �Ű������ִ� �����ڸ� ������ �ҷ��ü� ����.
		super(lastName);//�׷��Ƿ� �Ű������� ���� �־��� ���°� �Ǿ��Ѵ�.//super�� ������ ��ġ�ؾ��Ѵ�. 
		// super()�� ��� �����Ϸ��� �̰��� �߰������ش�. �ٵ� Parent��ü�� �Ű������� �ִ� �����ڻ��̹Ƿ� super���� ���� �Ű������� �־�����Ѵ�. 
		this.firstName=firstName;
	}
	//Method
	void play(){
		System.out.println("��ƿ�");
	}
	
}
