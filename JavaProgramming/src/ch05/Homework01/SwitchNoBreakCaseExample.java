package ch05.Homework01;

public class SwitchNoBreakCaseExample {

	public static void main(String[] args) {
		int time =(int)(Math.random()*4)+8;
		System.out.println("[현재시간: "+time+"시");
		
		switch(time){
		case 8:
			System.out.println("출근합니다.");
		case 9:
			System.out.println("출근합니다.");
		case 10:
			System.out.println("출근합니다.");
		case 11:
			System.out.println("출근합니다.");
		}
	}

}
