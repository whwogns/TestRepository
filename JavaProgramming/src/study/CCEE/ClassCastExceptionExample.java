package study.CCEE;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
		}
		public static void changeDog(Animal animal){ //�Ű����� Ÿ���� Dog�� ��ȯ��Ų�ٴ� ���ǹ������
			//if(animal instanceof Dog){ // animal�� ���� �Ű����� Ÿ���� Dog�� true��� ��. //instanceof�� ���� ��ü(����)�� Ÿ��(����)�� ��ġ�ϴ��İ� ���� �������̴�.
				Dog dog = (Dog) animal;
			//}
		}
	}


