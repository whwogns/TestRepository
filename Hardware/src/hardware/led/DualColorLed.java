package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class DualColorLed {
	//디지털 출력핀 필드
	private GpioPinDigitalOutput redPin; // 전원을 내보내기만 하기 때문에 output 사용
	//디지털 출력핀 필드
	private GpioPinDigitalOutput greenPin;

	public DualColorLed(Pin redPinNo, Pin greenPinNo) {
		//GpioController 객체 얻기
		GpioController gpioController = GpioFactory.getInstance();
		
		//디지털 출력핀 생성
		redPin = gpioController.provisionDigitalOutputPin(redPinNo);
		//애플리케이션이 종료될 때 출력 모드를 해제하고 핀의 출력을 LOW(0V)
		redPin.setShutdownOptions(true, PinState.LOW); // false일경우 출력이 마지막상태에서 유지된다
		
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo);
		greenPin.setShutdownOptions(true, PinState.LOW);
	}
	
	public void red(){
		redPin.high();
		greenPin.low();
	}
	public void green(){
		redPin.low();
		greenPin.high();
	}
	public static void main(String[] args) throws Exception{
		DualColorLed test = new DualColorLed(RaspiPin.GPIO_21, RaspiPin.GPIO_22);
//		for(int i=0 ; i<10 ; i++){
//			test.red();
//			Thread.sleep(500);
//			test.green();
//			Thread.sleep(500);
//		}
		while(true){
			test.red();
			Thread.sleep(3000);
			test.green();
			Thread.sleep(1000);
		}
	}
}
