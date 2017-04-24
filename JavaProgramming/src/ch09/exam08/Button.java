package ch09.exam08;

public class Button {
	
	//Field
	private OnClickListener onClickListener;
	//Constructor
	//Method
	public void setOnClickListener(OnClickListener onClickListener) { //세터를 통해 외부 객체가 여기로 호출됨.
		this.onClickListener = onClickListener;
	}
	
	public void touch(){    //이것을 이용하여 OnClick()을 실행시킴.
		if(onClickListener != null){
			onClickListener.onClick();
		}
	}
	
	//Nested Interface
	interface OnClickListener{
		void onClick();
	}

	
	
	

}
