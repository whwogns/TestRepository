package ch15.exam05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		String path = PropertiesExample.class.getResource("database.properties").getPath();  // 프로퍼티스이그잼클래스 파일 있는 곳에서 데이터배이스점프포퍼티스 파일의 경로를 찾아서 넣어주는것.
		prop.load(new FileReader(path));//"D:/IoTCourse/EclipseWorkspace/JavaProgramming/src/ch15/exam05/database.properties"
	
		String driver = prop.getProperty("driver");
		System.out.println(driver);
		
		String manager = prop.getProperty("manager");
		System.out.println(manager);
		
	
	}
	

}
