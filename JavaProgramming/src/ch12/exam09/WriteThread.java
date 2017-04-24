package ch12.exam09;

public class WriteThread extends Thread {
	
	//Field
	private DataBox dataBox;
	//Constructor
	public WriteThread(DataBox dataBox){
		this.dataBox = dataBox;
	} //이처럼 생성자로 외부데이터를 받는방법은 생성자주입 /// 세터를 통해서 외부데이터를 받는 방법 세터주입.
	//Method
	@Override
	public void run() {
		for(int i=0; i<10;i++){
			dataBox.setData(String.valueOf(i));
		}
	}

}
