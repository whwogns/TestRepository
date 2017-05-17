package test;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.button.Button;
import hardware.led.DualColorLed;
import java.io.IOException;

public class ButtonDualLedTest {

	public static void main(String[] args) throws IOException {
		Button button = new Button(RaspiPin.GPIO_00);
		DualColorLed test = new DualColorLed(RaspiPin.GPIO_21, RaspiPin.GPIO_22);

		button.setGpioPinListenerDigital((event) -> {
			if (event.getState() == PinState.HIGH) {
				test.green();// 안누를때
			} else {
				test.red();// 누를때 
			}
		});
		System.out.println("ready");
		System.in.read();
	}
}
