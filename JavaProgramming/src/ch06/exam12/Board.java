package ch06.exam12;

public class Board {
	//Field
	private int bno;
	private String title;
	private String content;
	private String writer;
	private boolean open;
	//Constructor
	
	
	//Method
	public void setBno(int bno) {
		if(bno<0)bno =0;
		this.bno = bno;
	}
	public void setTitle(String title) {
		this.title = title;
		//Source �޴����� ���� ���� ���� ���� �ڵ���� �ٷ� ����� �ִ�.
	}

	
	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setOpen(boolean open){
		this.open=open;
	}
//--------------------------------
	
	//����
	
	public int getBno(){
		return bno;
		

	}
	public String getTitle(){
		return title;
	}
   public boolean isOpen(){// boolean ���͸� is~�� �ٴ´�.
	   return open;
   }
}
