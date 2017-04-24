package ch11.exam07;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		//키이름을 알고있다면 해당키만 알면 그 키의 값을 알려고 할때 하는 방법.
		
		
		/*Properties props= System.getProperties();
		Set keys = props.keySet();
		for(Object objKey : keys){
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("["+key+"]"+value);*/
			
	      //프로퍼티안에 키값이 뭐가 있는지 확인하기 위한 것.
		}
	}


