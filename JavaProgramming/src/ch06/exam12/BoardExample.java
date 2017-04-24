package ch06.exam12;

public class BoardExample {

	public static void main(String[] args) {
		Board board = new Board();
		
		
		board.setBno(1);//필드는 프라이빗으로 막아놓고 메소드를 이용하여 접근하는 방법이다.
		board.setTitle("이제 봄입니다.");//마찬가지.
		board.setContent("놀러가야겠다");
		board.setWriter("홍자바");
		board.setOpen(true);
		
		System.out.println(board.getBno());
		System.out.println(board.getTitle());
	
		System.out.println(board.isOpen());
		
		
		
	}

}
