package ch06.exam07;

public class calculator {
	 	//Field
		static String model = "MI-84";
		static String makeDay="2017.03.29";
		static String info; //MI-84(2017.03.29)
		//static block : �ʵ忡�� ������ �� �ʿ䰡 ������, �����ڿ����� ��ü����� ���̰� ��ü�ƴ� ���� ����¶����� ����ƽ�� ����Ѵ�. �̶� ����ƽ�� �޼ҵ尡 �� ������ �����.
		//����ƽ�ʵ��� ������ ����� ����.
		
		static{
			info = model;
			info +="(";
			info += makeDay;
			info +=")";
		//�� ����ƽ��Ͼȿ��� ��ü�� ������ ���� �־ �ȵȴ�.
	}
	
	//
}
