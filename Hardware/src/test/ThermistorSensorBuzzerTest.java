package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.Converter.PCF8591;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.ThermistorSensor;

public class ThermistorSensorBuzzerTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		ThermistorSensor test1 = new ThermistorSensor(pcf8591);
		
		ActiveBuzzer test2 = new ActiveBuzzer(RaspiPin.GPIO_00);
			while(true){
			double value = test1.getValue();
				System.out.println(value);
			if(value>=28){
				test2.on();
			}else{
				test2.off();
			}
			Thread.sleep(1000);
			}
	}
}
