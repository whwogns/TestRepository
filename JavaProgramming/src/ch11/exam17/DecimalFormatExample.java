package ch11.exam17;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		double num = 1234567.89;
				
		DecimalFormat df = new DecimalFormat("0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("0.0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("0000000000.00000");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("#");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("#.#");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("##########.#####");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("#.0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("+#.0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("-#.0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("#,###.0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("0.0E0");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("+#,### ; -#,###");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("#.# %");
		System.out.println( df.format(num) );
		
		df = new DecimalFormat("\u00A4 #,###"); //원화 주기위해 유니코드로 주는 방법
		System.out.println( df.format(num) );
	}
}
