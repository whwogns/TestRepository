package ch15.exam05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		String path = PropertiesExample.class.getResource("database.properties").getPath();  // ������Ƽ���̱���Ŭ���� ���� �ִ� ������ �����͹��̽���������Ƽ�� ������ ��θ� ã�Ƽ� �־��ִ°�.
		prop.load(new FileReader(path));//"D:/IoTCourse/EclipseWorkspace/JavaProgramming/src/ch15/exam05/database.properties"
	
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		String manager = prop.getProperty("manager");
		System.out.println(manager);
		
	
	}
	

}
