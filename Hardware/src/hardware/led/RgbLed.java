/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class RgbLed {
	private GpioPinDigitalOutput redPin;
	private GpioPinDigitalOutput greenPin;
	private GpioPinDigitalOutput bluePin;

	public RgbLed(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		
		redPin = gpioController.provisionDigitalOutputPin(redPinNo, PinState.HIGH);
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo, PinState.HIGH);
		bluePin = gpioController.provisionDigitalOutputPin(bluePinNo, PinState.HIGH);
		
		redPin.setShutdownOptions(true, PinState.HIGH);
		greenPin.setShutdownOptions(true, PinState.HIGH);
		bluePin.setShutdownOptions(true, PinState.HIGH);
		
		
	}
	public void rgb(boolean red, boolean green, boolean blue){
		
		if(red) {redPin.low();}else{redPin.high();}
		if(green){greenPin.low();}else{greenPin.high();}
		if(blue){bluePin.low();}else{bluePin.high();}
		
	}
	public void red(boolean state){
		if(state){
			bluePin.low();
		}else{
			bluePin.high();
		}
	}
	public void green(boolean state){
		if(state){
			bluePin.low();
		}else{
			bluePin.high();
		}
	}
	public void blue(boolean state){
		if(state){
			bluePin.low();
		}else{
			bluePin.high();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		RgbLed test = new RgbLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		while(true){
			test.rgb(true, false, false);
			Thread.sleep(100);
			test.rgb(false, true, false);
			Thread.sleep(100);
			test.rgb(false, false, true);
			Thread.sleep(100);
		}
	}
}
