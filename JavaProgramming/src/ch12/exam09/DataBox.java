package ch12.exam09;

public class DataBox {

	//Field
	private String data; //데이터를 저장할 위치
	//Constructor
	//Method

	public synchronized String getData() {
		if(data == null){
			try {wait();} catch (InterruptedException e) {}
		}
		String returnValue = data;
		System.out.println("읽은데이터:"+returnValue);
		data = null;
		notify();
		return returnValue;
		
	}

	public synchronized void setData(String data) {
		if(this.data != null){
			try {wait();} catch (InterruptedException e) {}
		}
		this.data = data;
		System.out.println("생성데이터:"+data);
		notify();
	}
}
