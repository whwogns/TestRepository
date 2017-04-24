package study;

public class NullPointerExceptionExample {
	public static void main(String[] args){
		String data = null;
		System.out.println(data.toString()); // data라는 변수에는 어떤 객체를 가리키지도 않고 있으니 그것에 접근하려 하면 null익셉션이 동작.
	}

}
