package ch09.exam07;

public class Examle2 {

	public static void main(String[] args) {
		//로컬클래스를 정의하고 객체를 생성
		/*class CImpl implements A.C{
			@Override
			public void cMethod() {
				System.out.println("CImpl-cMethod()");
				
			}
		}
		//CImpl cimpl = new CImpl();
		//cimpl.cMethod();
		
	A.C c =new CImpl(); //바로위대신 이렇게 가능.
	c.cMethod();
	*/
	
		
		A.C c =new A.C(){
			@Override
			public void cMethod() {
				System.out.println("CImpl- cMethod()");
			}
		};
   c.cMethod();  // 이럴때 CImpl 은 익명객체.
	}

}
