package hardware.motor;

import com.pi4j.io.gpio.Pin;

public class SG90ServoPCA9685Duration {
	//Field
	private PCA9685 pca9685;
	private Pin pin;
	private int angle;
	private int minDuration;
	private int maxDuration;
	
	//Constructor
	
	public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin){
		
		//0도(0.8ms=800us): 0.8/0.004884 = 164단계  ---> minstep
		//180도 (2.7ms =2700us):2.7/0.004884 = 552단계  --->mamstep
		this(pca9685, pin, 800, 2700);
	}
	
	
	
	public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin, int minDuration, int maxDuration){
		this.pca9685 = pca9685;
		this.pin = pin;
		this.minDuration = minDuration;
		this.maxDuration = maxDuration;
	}
	
	//Method

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		if(angle<0){
			angle=0;
		}else if(angle>180){
			angle=180;
		}
		this.angle = angle;
		int duration = minDuration+(int)(angle*(maxDuration-minDuration)/180.0);
		this.pca9685.setDuration(pin, duration);
	}
	
	
	public static void main(String[] args) throws Exception{
		PCA9685 pca9685 = PCA9685.getInstance();
		SG90ServoPCA9685Duration servo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_15);   
		//PWM15 - 카메라상하 // PWM11 - 초음파좌우  // PWM14 - 카메라좌우 // PWM00 - 바퀴방향
		
//		for(int i=10; i<=180; i+=10){  
//		servo.setAngle(i);
//		Thread.sleep(500);
//		}
//		for(int i=170; i>=10; i-=10){
//		servo.setAngle(i);
//		Thread.sleep(500);
//		}
	servo.setAngle(90);
	Thread.sleep(1000);
	}
}
