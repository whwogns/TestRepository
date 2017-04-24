package ch10.exam05;

public class BalaceInsufficientException extends Exception{
	public BalaceInsufficientException(){}   //예외 객체 생성자 
	public BalaceInsufficientException(String message){
		super(message);
	}
}
