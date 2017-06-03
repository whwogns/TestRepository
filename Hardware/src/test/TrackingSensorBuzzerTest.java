package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.TrackingSensor;
import java.io.IOException;

public class TrackingSensorBuzzerTest {
	public static void main(String[] args) throws IOException {
		TrackingSensor test1 = new TrackingSensor(RaspiPin.GPIO_00);
		ActiveBuzzer test2 = new ActiveBuzzer(RaspiPin.GPIO_02);
		test1.setGpioPinListenerDigital(event ->{
			if(event.getState() == PinState.HIGH){
				test2.off();
			}else{
				test2.on();
			}
		});
		System.out.println("ready...");
		System.in.read();
	}
}
