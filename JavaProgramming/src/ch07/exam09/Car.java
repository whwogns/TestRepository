package ch07.exam09;

public class Car {
	//Field
	private Tire tire;  
	//Constructor
	public Car(Tire tire){
		this.tire=tire;        
	}
	//Method
	
	public void run(){     
		tire.roll();
		/*SnowTire snowTire = (SnowTire) tire; //SnowTire�� ������ ������ȯ������, �� SnowTire�� ������ ������ ��ȯ�� �ȵǴ� ����. �̸� ,instanceof,�ΰ˻�
		snowTire.notSlide();
		*/
		if(tire instanceof SnowTire){  //instanceof�� �ϳ��� �������̴�. �� �����Ÿ�̾ ���Եɶ��� �� �޼ҵ尡 ���ư��� �ȴ�.
		SnowTire snowTire = (SnowTire) tire; //SnowTire�� ������ ������ȯ������, �� SnowTire�� ������ ������ ��ȯ�� �ȵǴ� ����. �̸� ,instanceof,�ΰ˻�
		snowTire.notSlide();
		}
	}

	public void setTire(Tire tire) {      //4. �޼ҵ带 ���ؼ� ��ü�� ��ȯ�ϱ� ���� ���͸� �̿�.
		this.tire = tire;
	}

}
