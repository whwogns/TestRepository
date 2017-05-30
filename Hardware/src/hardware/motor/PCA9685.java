package hardware.motor;

import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class PCA9685 {
	//Field
	private static PCA9685 singleton;
	public static PCA9685 getInstance() throws Exception{
		if(singleton == null){
			singleton = new PCA9685();
		}
		return singleton;
	}
	
	private PCA9685GpioProvider gpioProvider; // gpio에서 제공하는 것으로 이용하면 됨
	
	private static final Pin PWM_00=PCA9685Pin.PWM_00;//쓰기쉽게 상수로 정의한것인것뿐
	private static final Pin PWM_01=PCA9685Pin.PWM_01;
	private static final Pin PWM_02=PCA9685Pin.PWM_02;
	private static final Pin PWM_03=PCA9685Pin.PWM_03;
	private static final Pin PWM_04=PCA9685Pin.PWM_04;
	private static final Pin PWM_05=PCA9685Pin.PWM_05;
	private static final Pin PWM_06=PCA9685Pin.PWM_06;
	private static final Pin PWM_07=PCA9685Pin.PWM_07;
	private static final Pin PWM_08=PCA9685Pin.PWM_08;
	private static final Pin PWM_09=PCA9685Pin.PWM_09;
	private static final Pin PWM_10=PCA9685Pin.PWM_10;
	private static final Pin PWM_11=PCA9685Pin.PWM_11;
	private static final Pin PWM_12=PCA9685Pin.PWM_12;
	private static final Pin PWM_13=PCA9685Pin.PWM_13;
	private static final Pin PWM_14=PCA9685Pin.PWM_14;
	private static final Pin PWM_15=PCA9685Pin.PWM_15;
	
	private int period;
	
	//Constructor
	private PCA9685() throws Exception{  //객체하나만만들어야하므로 싱글톤+쓴것임
		I2CBus i2cBus = I2CFactory.getInstance(I2CBus.BUS_1);
		//0x40: PCA9685 모듈의 I2C 장치 번호
		//PWM 주파수를 50Hz 로 설정(SG90 Servo Motor가 50Hz에서 동작하기때문)
		gpioProvider = new PCA9685GpioProvider(i2cBus, 0x40, new BigDecimal(50));
		//한 사이클당 시간(period) : 1초/frequency = 1/50Hz = 0.02s = 20ms = 20000us
		period = gpioProvider.getPeriodDurationMicros(); //period = 20000
		
		//GPIO PWM 출력핀설정
		GpioController gpioController = GpioFactory.getInstance();  
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_00);  //핀을 모두 아웃풋으로 쓰겟다는 것.
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_01);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_02);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_03);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_04);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_05);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_06);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_07);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_08);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_09);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_10);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_11);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_12);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_13);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_14);
		gpioController.provisionPwmOutputPin(gpioProvider, PWM_15);
		
		gpioProvider.reset();
	}
	
	
	public void setDuration(Pin pin, int duration){  //high가 된 구간의 시간
		//duration : 0~19999us (20000은 안됨 한번은 떨어져야 cycle임)
		if(duration>=period){
			duration = (period-1);
		}else if(duration<0){
			duration = 0;
		}
		if(duration !=0){
		gpioProvider.setPwm(pin, duration);
		}else{
			gpioProvider.setAlwaysOff(pin);
		}
	}
	
	public void setStep(Pin pin, int step){
		//step : 0~4095
		if(step >= 4096){
			step = 4095;
		}else if(step<0){
			step=0;
		}
		if(step !=0){
			gpioProvider.setPwm(pin, 0, step);
		}else{
			gpioProvider.setAlwaysOff(pin);
		}
	}
	
	//Method
	public static void main(String[] args) throws Exception{
		PCA9685 pca9685 = PCA9685.getInstance();
		
		//0도로 회전
		//pca9685.setDuration(PWM_01, 750); //360도로 돌아가는 모터의 경우에는 800아닌 750~ 2700이 아닌 2500.
		pca9685.setStep(PWM_00, 185);
		Thread.sleep(2000);
		//90도 회전
		//pca9685.setDuration(PWM_02, (750+2500)/2);
		pca9685.setStep(PWM_00, 358);
		Thread.sleep(2000);
		//180도 회전
		//pca9685.setDuration(PWM_00, 2500);
		pca9685.setStep(PWM_00, 550);
		
		Thread.sleep(2000);
	}
}
