package ch12.exam11;

public class DaemonExample {

	public static void main(String[] args) {
		
	System.out.println("워드프로세스를 시작함");
	
	
	AutoSaveThread thread = new AutoSaveThread(); //이 오토스레드를 보조스레드로 만들어주면 됨.
	thread.setDaemon(true);
	thread.start();
	
	try {thread.sleep(5000);} catch (InterruptedException e) {}
	System.out.println("워드프로세스를 종료함");
	}
}
