package ch06.exam03;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		calc.powerOn();//메소드 호출
		String info = calc.info();
		System.out.println(info);
		
		int result1=calc.plus(10, 20);
		System.out.println(result1);
		
		double result2 = calc.divide(10.5, 5.2);
		System.out.println(result2);
		
		int[] result3 = calc.changeArray(10, 20, 30);
		for(int value : result3){     //왜 포문?
			/*for(int i=0;i<result.length;i++){
			System.out.println(result[i]);*/
			System.out.print(value+"");
		}
		System.out.println();//계행이몬데..
		
		Car result4 = calc.makeCar("검정",true);
		System.out.println(result4.color);
		System.out.println(result4.airback);//이해안댐
	}

}
