package ch06.exam08;

public class calculator {
	 	static calculator singleton = new calculator();
	private calculator(){//클래스밖에서 못 불러간다. 호출안됨. 얘가 자기만 쓸수있음.
		
	}
	
	static calculator getInstance(){//이때 스태틱 쓰는 이유는 프라이빗 calculator인데 끌어다 쓰기위해 객체를 필요로하지않는 static을 사용하는것
		
		return singleton;
	}
}
