package ch07.exam07;

public class CarExample {

	public static void main(String[] args) {
		
		//Tire tire=new NormalTire();//
	
		Car car= new Car(new SnowTire());// 1. �����ڿ� �Ű�����(Ÿ�̾�����) �Է� ��. 
		car.run();               //�ش� Ÿ�̾����� �����/ run()�� �����ϸ� Car�� �޼ҵ尡 ����Ǿ�  roll()�� �����.��
		
		
		car.setTire(new NormalTire());//2. ���Ϳ� ���� ��ü�� �븻Ÿ�̾�� �ٲ��� 
		car.run();
		
		car.setTire(new SpeedTire());//3. ���Ϳ� ���� ��ü�� ���ǵ�Ÿ�̾�� �ٲ���
		car.run();
		
		car.setTire(new SuperTire());//4. ���Ϳ� ���� ��ü�� ����Ÿ�̾�� �ٲ���
		car.run();
		
	}

}
