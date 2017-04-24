package ch09.exam06;

public class Example implements A.B{
	@Override
	public void method() {   //재정의해야함.
		
		
	}

	public static void main(String[] args) {
		
		class C implements A.B(){
			@Override
			public void method() {   //재정의해야함.
				
				
			}
		}

	}
}
