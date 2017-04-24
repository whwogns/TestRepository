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
		//Source 메뉴에서 세터 게터 에서 위의 코드들을 바로 만들수 있다.
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
	
	//게터
	
	public int getBno(){
		return bno;
		

	}
	public String getTitle(){
		return title;
	}
   public boolean isOpen(){// boolean 게터만 is~가 붙는다.
	   return open;
   }
}
