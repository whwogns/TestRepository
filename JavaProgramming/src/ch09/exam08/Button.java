package ch09.exam08;

public class Button {
	
	//Field
	private OnClickListener onClickListener;
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener onClickListener) { //���͸� ���� �ܺ� ��ü�� ����� ȣ���.
		this.onClickListener = onClickListener;
	}
	
	public void touch(){    //�̰��� �̿��Ͽ� OnClick()�� �����Ŵ.
		if(onClickListener != null){
			onClickListener.onClick();
		}
	}
	
	//Nested Interface
	interface OnClickListener{
		void onClick();
	}

	
	
	

}
