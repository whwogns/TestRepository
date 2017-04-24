package ch11.exam05;

public class GcExample {

	public static void main(String[] args) {
		
		Member m1 = new Member("blue");
		m1 = null;
		
		m1 = new Member("white");
		m1 = new Member("red");
		
		System.gc();
	}

}
