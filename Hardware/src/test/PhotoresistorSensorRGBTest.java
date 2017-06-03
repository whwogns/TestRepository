package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.Converter.PCF8591;
import hardware.led.RgbLedPWM;
import hardware.sensor.PhotoresistorSensor;

public class PhotoresistorSensorRGBTest {
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		PhotoresistorSensor test1 = new PhotoresistorSensor(pcf8591);
		RgbLedPWM test2 = new RgbLedPWM(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		while(true){
			double value = test1.getValue();
			System.out.println(value);
			if(value<=50){
				test2.ledColorSet(50, 0, 0);
			}else if(value<=100){
				test2.ledColorSet(0, 50, 0);
			}else{
					test2.ledColorSet(255, 255, 255);
					}
			
			Thread.sleep(1000);
		}
	}
}
