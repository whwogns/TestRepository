package study.CCEE;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
		}
		public static void changeDog(Animal animal){ //매개값의 타입이 Dog면 변환시킨다는 조건문만들기
			//if(animal instanceof Dog){ // animal로 들어올 매개값의 타입이 Dog면 true라는 뜻. //instanceof의 뜻은 객체(좌향)의 타입(우향)이 일치하느냐고 묻는 연산자이다.
				Dog dog = (Dog) animal;
			//}
		}
	}


