package test;

import com.pi4j.io.gpio.RaspiPin;
import hardware.Converter.PCF8591;
import hardware.buzzer.ActiveBuzzer;
import hardware.led.DualColorLed;
import hardware.motor.SG90Servo;
import hardware.sensor.GasSensor;

public class GasSensorBuzzuerDualLedServoMotorTest {

	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN0);
		GasSensor test1 = new GasSensor(pcf8591, RaspiPin.GPIO_00);

		DualColorLed test2 = new DualColorLed(RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		ActiveBuzzer test3 = new ActiveBuzzer(RaspiPin.GPIO_22);
		SG90Servo test4 = new SG90Servo(RaspiPin.GPIO_01, 7, 23);
		//방법1: digital 핀의 상태를 이용

		while (true) {
			double value = test1.getValue();
			System.out.println(value);
			if (value > 200) {
				test2.red();
				test3.on();
				
					test4.setAngle(180);
				
				
			} else {
				test4.setAngle(0);
				test2.green();
				test3.off();
			}
		}
	}
}
