package ch09.exam07;

public class Example {
	
	public static void main(String[] args) {
		//로컬클래스를 정의하고 객체 생성
		//B를 상속해서 새로운 B2만들고 그것의 객체생성
		/*
		class B2 extends A.B{
			@Override
			void bMethod() {
				System.out.println("B2-bMethod()");
			}
		}
		A.B b = new B2();
		b.bMethod();
		*/
		//이부분을 간단히 하는 방법.
		
		A.B b = new A.B(){//생성자를 호출하는것임. 객체를 만드는데 B를 상속()하여 자식의 것을 정의{}하고 자식객체를 생성시켜 b에 저장. ( ==> (){} 해석방법  )
			@Override
			void bMethod() {
				
			}
		};
		
		b.bMethod();
		
	}
}
