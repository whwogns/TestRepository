package ch06.exam09;

public class Member {
	String name;
	final String ssn;//final �������� ���̴� ���̻� �ٲܼ� ����. �����ڸ� ���ؼ��� �� �ѹ��� �����ȸ�� �ְ� ���Ŀ��� �����Ҽ�����.
	//�̶� ���⿡ ���� ���� �־������ ���Ŀ� �����ڿ��� �ѹ������� �ٲܼ����Եȴ�.
	Member(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
}
