package ch05.exam01;

public class CallByValueAndCallByReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1 = 10;
		int v2 = 20;
		int v3 = sum(v1, v2);
		System.out.println("v1:" +v1);
		System.out.println("v2:" +v2);
		System.out.println("v3:" +v3);
		
		int[] v4 = {10,20};// 100번지를 불러옴
		
		System.out.println("v4[0]:" +v4[0]);
		System.out.println("v2[1]:" +v4[1]);
	
		int v5 = sum(v4); 
		System.out.println("v4[0]:" +v4[0]);
		System.out.println("v2[1]:" +v4[1]);
		System.out.println("v5:" + v5);
		
	}

	public static int sum(int x, int y){
		x = 30;
		y = 40;
		return (x + y);
	}
	public static int sum(int [] scores){  //v4를 그대로가져오므로 역시 100번지를 불러옴
		scores[0] = 30;
		scores[1] = 40;
		int sum = 0;
		for(int i=0; i<scores.length; i++){
			sum += scores[i];
		}
		return sum;
	}
}
