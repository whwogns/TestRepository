package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.UltraSonicSensor;

public class BuzzerActiceUltraSonicSensor {

	public static void main(String[] args) throws Exception {
		UltraSonicSensor test1 = new UltraSonicSensor(RaspiPin.GPIO_00, RaspiPin.GPIO_01);
		ActiveBuzzer test2 = new ActiveBuzzer(RaspiPin.GPIO_02);
		while (true) {
			int distance = test1.getDistance();
			if(distance<20){
				test2.on();
			}else{
				test2.off();
			}
		}
	}
}
