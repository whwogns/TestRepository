package ch12.exam09;

public class WriteThread extends Thread {
	
	//Field
	private DataBox dataBox;
	//Constructor
	public WriteThread(DataBox dataBox){
		this.dataBox = dataBox;
	} //��ó�� �����ڷ� �ܺε����͸� �޴¹���� ���������� /// ���͸� ���ؼ� �ܺε����͸� �޴� ��� ��������.
	//Method
	@Override
	public void run() {
		for(int i=0; i<10;i++){
			dataBox.setData(String.valueOf(i));
		}
	}

}