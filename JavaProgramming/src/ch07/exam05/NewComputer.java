package ch07.exam05;

public class NewComputer extends Computer{
		//c.f)���� �����Ǵ� �޼ҵ带 ��������.
	
	@Override
	double circleArea(double r) {
		return Math.PI *r*r; //�������Ѱ���. / �̶�  plus �޼ҵ�� ���̳��� �پ������� �������̵� �� �� ����.
	}

}
