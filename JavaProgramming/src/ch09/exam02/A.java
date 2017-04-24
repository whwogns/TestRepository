package ch09.exam02;

public class A {
	//Field
	int aField;
		//Constructor
		
		A(){
			//로컬 클래스
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
			//로컬클래스
			class E{
				//Field
				//Constructor
				//Method
				void eMethod(){
			    aField=10;
			}
		}
		
		//Nested Class (중첩 멤버 클래스)
		class B {
			//Field
			//Constructor
			//Method
			void bMethod(){
			aField=0;
			}
		} // 스태틱이 안붙었으니 A객체없이는 A에는 접근못함.  // A를 떠나서는 B가 의미없는 경우에 쓰임
		static class C{
			//Field
			//Constructor
			//Method
			void cMethod(){
			//aField=0; 이건 스태틱붙었으니 
			}
			} //A클래스(A객체) 없이도 C사용가능  얘를 더 많이씀.  // A와 전혀 관계없으나 A에서 유래한것이라는 것을 알리기 위해 쓰임.
		}
}

