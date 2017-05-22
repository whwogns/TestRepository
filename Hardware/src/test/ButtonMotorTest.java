package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.button.Button;
import hardware.motor.SG90Servo;
import java.io.IOException;

public class ButtonMotorTest {
	public static void main(String[] args) throws IOException {
		Button button1 = new Button(RaspiPin.GPIO_00);
		Button button2 = new Button(RaspiPin.GPIO_02);
		Button button3 = new Button(RaspiPin.GPIO_03);
		SG90Servo test = new SG90Servo(RaspiPin.GPIO_01,7,23);
		button1.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.HIGH){
					System.out.println("high"); // 안누를때
				}else{
					
					test.setAngle(0);
				}
			}
			
		});
		button2.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.HIGH){
					System.out.println("high"); // 안누를때
				}else{
					
					test.setAngle(90);
				}
			}
			
		});
		button3.setGpioPinListenerDigital(new GpioPinListenerDigital(){
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState() == PinState.HIGH){
					System.out.println("high"); // 안누를때
				}else{
					
					test.setAngle(180);
				}
			}
			
		});
		System.out.println("ready");
		System.in.read();
	}

}
