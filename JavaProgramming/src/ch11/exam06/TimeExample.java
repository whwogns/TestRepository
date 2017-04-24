package ch11.exam06;

public class TimeExample {

	public static void main(String[] args) {
		
		int sum =0;
		
		//long startTime = System.currentTimeMillis(); //밀리언 단위로 측정
		long startTime = System.nanoTime(); //나노 단위로 측정
		for(int i=0;i<100000000;i++){
			sum+=i;
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
	}

}
