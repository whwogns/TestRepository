package ch10.exam06;

public class BalaceInsufficientException extends Exception{
	public BalaceInsufficientException(){}   //���� ��ü ������ 
	public BalaceInsufficientException(String message){
		super(message);
	}
}
