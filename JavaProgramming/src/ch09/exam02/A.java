package ch09.exam02;

public class A {
	//Field
	int aField;
		//Constructor
		
		A(){
			//���� Ŭ����
			class D {
				//Field
				//Constructor
				//Method
				void aMethod(){
					aField=10;
				}
				
			}
		}
		//Method
		void amethod(){
			//����Ŭ����
			class E{
				//Field
				//Constructor
				//Method
				void eMethod(){
			    aField=10;
			}
		}
		
		//Nested Class (��ø ��� Ŭ����)
		class B {
			//Field
			//Constructor
			//Method
			void bMethod(){
			aField=0;
			}
		} // ����ƽ�� �Ⱥپ����� A��ü���̴� A���� ���ٸ���.  // A�� �������� B�� �ǹ̾��� ��쿡 ����
		static class C{
			//Field
			//Constructor
			//Method
			void cMethod(){
			//aField=0; �̰� ����ƽ�پ����� 
			}
			} //AŬ����(A��ü) ���̵� C��밡��  �긦 �� ���̾�.  // A�� ���� ��������� A���� �����Ѱ��̶�� ���� �˸��� ���� ����.
		}
}

