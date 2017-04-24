package ch07.exam09;

public class Car {
	//Field
	private Tire tire;  
	//Constructor
	public Car(Tire tire){
		this.tire=tire;        
	}
	//Method
	
	public void run(){     
		tire.roll();
		/*SnowTire snowTire = (SnowTire) tire; //SnowTire가 들어오면 강제변환되지만, 꼭 SnowTire가 들어오지 않으면 변환이 안되는 문제. 이를 ,instanceof,로검사
		snowTire.notSlide();
		*/
		if(tire instanceof SnowTire){  //instanceof는 하나의 연산자이다. 즉 스노우타이어가 대입될때만 이 메소드가 돌아가게 된다.
		SnowTire snowTire = (SnowTire) tire; //SnowTire가 들어오면 강제변환되지만, 꼭 SnowTire가 들어오지 않으면 변환이 안되는 문제. 이를 ,instanceof,로검사
		snowTire.notSlide();
		}
	}

	public void setTire(Tire tire) {      //4. 메소드를 통해서 객체를 변환하기 위해 세터를 이용.
		this.tire = tire;
	}

}
