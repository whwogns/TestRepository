package ch07.exam08;

public abstract class Tire {  //�߻�Ŭ������ �߻� �޼ҵ常 �־���ϴ°����ƴϴ�.
	
	//Field
	int diameter;
	//Constructor
	Tire(){
		System.out.println("Tire ��ü ����");
	}
	//Method
	abstract void roll();
	
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
}
//�߻� �޼ҵ� ����.