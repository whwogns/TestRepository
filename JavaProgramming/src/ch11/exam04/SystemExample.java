package ch11.exam04;

public class SystemExample {
	
	public static void main(String[] args){
		System.setSecurityManager(new SecurityManager(){
			@Override
			public void checkExit(int status) {
				if(status != 54321){
					throw new SecurityException();   //실행예외므로 throws안붙여도됨.
				}
			}
		});
		
		
		
		for(int i=0;i<10;i++){
			System.out.println(i);
			if(i==5){
				try{
				System.exit(0); //0이아닌 다른값을 줘야만 jVM이 종료되도록 설정할 수있다.
				
			}catch(SecurityException e){}
		}
	}
		
	}
}


//이와 같을때 54321일때만 jvm이 종료된다.

//상식적으로만 알아두면 됨 많이안쓰임,.