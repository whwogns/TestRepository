package hardware.Converter;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PCF8591 {
	public static final int AIN0=0x40;
	public static final int AIN1=0x41;
	public static final int AIN2=0x42;
	public static final int AIN3=0x43;  //핀번호를 상수화시켜 관리하고자.
	
	private int i2cAddress;
	private int ainNo;
	private int analogVal;
	
	//Constructor
	public PCF8591(int i2cAddress, int ainNo){
		this.i2cAddress=i2cAddress;
		this.ainNo=ainNo;
	}
	
	//Method
	public int analogRead() throws Exception{
		I2CBus i2cBus = I2CFactory.getInstance(I2CBus.BUS_1);
		I2CDevice i2cDevice = i2cBus.getDevice(i2cAddress);
		i2cDevice.read(ainNo);//dummy read
		analogVal = i2cDevice.read(ainNo);  // 가변저항값으로 조정할때 0~255범위내에서 값을 가진다.
		return analogVal;
	}
	
	public void analogWrite(byte value) throws Exception {
		I2CBus i2cBus = I2CFactory.getInstance(I2CBus.BUS_1);
		I2CDevice i2cDevice = i2cBus.getDevice(i2cAddress);
		i2cDevice.write(AIN0, value);
	}
	
	public static void main(String[] args) throws Exception {
		PCF8591 test = new PCF8591(0x48, AIN0);
		while(true){
			//아날로그값읽기
			int value = test.analogRead();
			System.out.println(value);
			//아날로그값출력
			test.analogWrite((byte)value);
			Thread.sleep(200);
		}
	}
}
