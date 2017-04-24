package ch14.assignment.exam01;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MyFunctionalInterfaceExample {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi=()->{
			String str="method call1";
			System.out.println(str);
		};
		fi=new MyFunctionalInterface(){
			@Override
			public void method() {
				String str="method call1";
				System.out.println(str);
			}
		};
		
		/* class A implements MyFunctionalIntefae{
		 * 
		 * @Override
		 * public void method(){
		 * syso("¾È³ç");
		 * }
		 * 
		 * public static void main(String []args){
		 *  A a=new A();
		 *  a.method();
		 * }		
		 */
			
		fi.method();
		fi.method();
		
		
		fi = () -> {System.out.println("method call2");};
		fi.method();
		
		
		fi = ()-> System.out.println("method call3");
		fi.method();
	}

}
