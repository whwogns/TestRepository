package ch09.exam07;

public class Examle2 {

	public static void main(String[] args) {
		//����Ŭ������ �����ϰ� ��ü�� ����
		/*class CImpl implements A.C{
			@Override
			public void cMethod() {
				System.out.println("CImpl-cMethod()");
				
			}
		}
		//CImpl cimpl = new CImpl();
		//cimpl.cMethod();
		
	A.C c =new CImpl(); //�ٷ������ �̷��� ����.
	c.cMethod();
	*/
	
		
		A.C c =new A.C(){
			@Override
			public void cMethod() {
				System.out.println("CImpl- cMethod()");
			}
		};
   c.cMethod();  // �̷��� CImpl �� �͸�ü.
	}

}
