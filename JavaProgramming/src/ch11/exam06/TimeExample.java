package ch11.exam06;

public class TimeExample {

	public static void main(String[] args) {
		
		int sum =0;
		
		//long startTime = System.currentTimeMillis(); //�и��� ������ ����
		long startTime = System.nanoTime(); //���� ������ ����
		for(int i=0;i<100000000;i++){
			sum+=i;
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
	}

}
