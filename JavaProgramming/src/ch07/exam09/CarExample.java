package ch07.exam09;

public class CarExample {

	public static void main(String[] args) {
		
		//Tire tire=new NormalTire();//
	
		Car car1= new Car(new SnowTire());// 1. �����ڿ� �Ű�����(Ÿ�̾�����) �Է� ��. 
		car1.run();               //�ش� Ÿ�̾����� �����/ run()�� �����ϸ� Car�� �޼ҵ尡 ����Ǿ�  roll()�� �����.��
		
		Car car2= new Car(new NormalTire());// 1. �����ڿ� �Ű�����(Ÿ�̾�����) �Է� ��. 
		car2.run();               //�ش� Ÿ�̾����� �����/ run()�� �����ϸ� Car�� �޼ҵ尡 ����Ǿ�  roll()�� �����.��
		
		
	}

}
