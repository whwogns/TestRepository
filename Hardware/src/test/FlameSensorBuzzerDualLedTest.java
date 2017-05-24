package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.Converter.PCF8591;
import hardware.buzzer.ActiveBuzzer;
import hardware.led.DualColorLed;
import hardware.sensor.FlameSensor;

public class FlameSensorBuzzerDualLedTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		FlameSensor test1 = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
		
		ActiveBuzzer test2 = new ActiveBuzzer(RaspiPin.GPIO_01);
		DualColorLed test3 = new DualColorLed(RaspiPin.GPIO_21, RaspiPin.GPIO_22);
		//방법1: digital 핀의 상태를 이용
		
		test3.green();
		test1.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState()==PinState.LOW){
					test2.on();
					test3.red();
				}else{
					test2.off();
					test3.green();
				}
				
			}
			
		});
		System.out.println("dd");
		System.in.read();
		
	}
}
