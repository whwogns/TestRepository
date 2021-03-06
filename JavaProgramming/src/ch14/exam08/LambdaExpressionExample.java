package ch14.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;



public class LambdaExpressionExample {
	private static List<Student> list = Arrays.asList(   //필드임.
			new Student("홍길동",90,96),
			new Student("감자바",95,93)
			);
	
	public static void main(String[] args) {
		printString((s)->{return s.getName();});
		
		printInt((a)->{return a.getEnglishScore();});
		
		double englishAvg = avg((s)->{return s.getEnglishScore();});
		System.out.println("영어 평균 점수:"+englishAvg);
		
		double mathAvg = avg((s)->{return s.getMathScore();});
		System.out.println("수학 평균 점수:"+mathAvg);
	}
	
	
	
	public static void printString(Function<Student, String>function){
		for(Student student : list){
			System.out.print(function.apply(student)+" ");
		}
		System.out.println();
	}
	public static void printInt(ToIntFunction<Student>function){
		for(Student student : list){
			System.out.print(function.applyAsInt(student)+" ");
		}
		System.out.println();
	}
	
	public static double avg(ToIntFunction<Student>function){   //평균을 구하는 포맷. 어떤평균인지는 구현해주어야함. // ToIntFunction은 객체를 받아서 int값을 출력시키겠다는 인터페이스이다.
		//그래서 int값을 뽑아내고 그 뽑아낸 int값으로 for문에 적용시켜 연산후 리턴값을 double로 준다.
		//이때 어떤 int값을 뽑아낼지는 구현하는 객체에 따라서 다르다.
		int sum =0;
		for(Student student :list){
			sum+=function.applyAsInt(student);
			
		}
		double avg= (double)sum/list.size();
		return avg;
	}
}
